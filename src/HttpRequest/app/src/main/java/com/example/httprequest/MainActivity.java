package com.example.httprequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    EditText에 우리가 입력한 HTTP 주소를 String형태로 가져온다.
                 */
                final String uriStr = et.getText().toString();

                /*
                    Thread 또한 , 프로세스라고 생각하면 된다.
                    약간의 차이점이 있다면, 프로세스는 메모리를 공유하지 않으며,
                    스레드는 메모리를 공유한다는 것이다.
                    그렇기때문에 동기화 문제 및 Critical Section등의 동기화문제에 대한
                    고찰이 필요하다.
                 */
                new Thread(new Runnable() { //interface는 반드시 abstract를 구현해야한다 -> 그래서 익명 클래스로 구현함.
                    /*
                        Thread의 run()이 동작하는 시점이
                        굉장히 어려운 개념 중 하나인데
                        프로세스들이 Context Switching을 하면서
                        "CPU를 획득하기 위한 경쟁"을 한다고 했었다.
                        바로 Thread의 run()도 이 경쟁에 함께 참여한다.
                        그러므로 제어권이 넘어갈 때마다 동작하게 되며
                        다른 프로세스 보다 '우선순위'가 높아
                        보다 자주 실행할 수 있는 기회를 얻게 된다. ( = CPU를 더 많이획득하게 되어 성능이 좋다 =반응 속도가 좋다)

                        *주의점 : 동기화 문제를 제대로 해결하지 못한다면, 오히려 안좋은 성능 혹은 잘못된 결과를 초래함.
                        (세마포어, 싱크로나이즈, 스핀락 을 공부해서 사용하면 좋다. --> 병렬처리와 관련된 내용 *****)
                     */
                    @Override
                    public void run() {
                        request(uriStr);
                    }
                }).start();
                /*
                      이 start()는 실제 run()을 동작시키게 한다.
                      결국, 익명 객체를 만들면서 Thread가 시작된다.
                      ( 이번 경우에서는 click했을 때만 동작하도록 구현되어 있다. )

                 */

            }
        });
    }
    public void request(String uriStr){
        /*
            StringBuilder는 문자열을 만드는 녀석이다.
         */
        StringBuilder output = new StringBuilder();

        try {
            /*
                우리가 입력한 http://www.naver.com을 URL타입으로 만든다.
             */
            URL url = new URL(uriStr);


            /*
                실제 HTTP프로토콜(80번)을 사용해서
                URL 주소와 TCP/IP Session을 맺는다.( 3way handshaking)
             */
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            /*
                con== null 이라는 것은 세가지 경우 중 하나이다.
                1. 없는 주소를 입력한 것
                2. 진짜 서버가 다운된 상태
                3. 방화벽에 막힌 상태( 사내 서버가 막힌 상태 - 실무에서 가장 많이 발생하는 문제이다.
                                    리눅스의 경우 iptables로 방화벽을 풀어야 한다.)
                                    이 경우, IP제한, 포트제한을 의미하기도 한다.
             */
            if (con != null) {
                // 일정 시간이 지나면 자동으로 Session 해제.
                con.setConnectTimeout(10000);

                /*
                 Web에서 사용하는 방식( 네트워크 전송 방식)이 두 가지가 있다.
                 1. GET
                 2. POST
                 */
                con.setRequestMethod("GET"); // 주로 GET방식으로 웹정보를 가져옵니다.


                // 입력을 받을 것인지 물어보는 코드 -> true -> 입력을 하겠다.
                con.setDoInput(true);


                /*
                    HTTP Response Code를 받는다.
                    이 부분은 디버깅시 매우 유용하다.
                    왜? (https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

                 */
                int resCode = con.getResponseCode(); // 403 ,404, 405등의 메세지


                /*
                    BufferedReader와 InputStreamReader가 보이는데
                    'Stream'이란 것의 정체를 파악하는 것이 무엇보다 중요하다.
                    순서가 반드시 지켜져야 하는 것이 Stream이다.

                    그럼 여기서 왜 Stream을 사용했을까?
                    기본적으로 Network동작은 Stream동작이 아니기 떄문이다.
                    결국 , 순차성을 보장하기 위해 사용하는 것이 InputStreamReader이며
                    데이터를 빠르게 처리하기 위한 녀석은 BufferedReader( 실제로 코드를 까보면 원형 큐)에 해당한다.
                    즉, 빠르면서 순차성을 보장(정확하게)하기 위한 형식임.
                    이런 자료구조는 원형 큐(환형 큐)이다. ( 순차적이면서 빠르다. )
                 */
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String line = null;

                /*While루프는 HTML코드를 뿌려주게 된다.*/
                while (true) {
                    line = reader.readLine(); // 한 줄씩 읽어옴
                    if (line == null) {// 더이상 읽을 줄이 없다면
                        break;
                    }
                    output.append(line + "\n");
                }
                reader.close();
                con.disconnect();
            }
        } catch (Exception e) {
            println("Exception Cccurance : " + e.toString());
        }
        println("Request Code :" + output.toString());
    }

    public void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv.append(data + "\n");
            }
        });
    }
}

/*
    내일 작업 내용 :
    1. Notification 주석 달기
    2. DB update, delete , query 작성

    내일 모레 :
    1. Animation 기능 추가

    마지막:
    1. 서비스 추가( 특정 조건 만족시 자동 Notification)
 */
