package com.example.context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;


/*
        문제 22 . 오늘 우리는 Activity를 동적으로 추가하는 방법을 배웠다.
                  LayoutInflater를 통해 Context도 관리 할 수 있다.
                  XML의 도움 없이 버튼을 누르면
                  계속 LinearLayout이 추가되도록
                  오늘의 예제 프로그램을 개조해보자!
                  ( 오늘 배운것 + 저번 과제에서 코드로 Linearlayout을 추가했던 부분을 참고해보자.)

 */
public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    /*
       AndroidManifest.xml에 Activity -> Intent filter -> Action쪽에서

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); //xml 출력

        container = (LinearLayout) findViewById(R.id.container);// container = LinearLayout

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() { // 버튼이 눌릴 때 실행되는 Action
            @Override
            public void onClick(View v) {
                /*
                    Layout과 관련된 Context를 모두 처리함.
                 */
                //context처리는 LayoutInflater로
                LayoutInflater inflater=
                (LayoutInflater)getSystemService(
                        LAYOUT_INFLATER_SERVICE
                );

                /*
                    LinearLayout인 container에
                    sub_res.xml을 배치하겠다는 의미
                 */
                inflater.inflate( // xml로 치면 LinearLayout안에 sub_res.xml을 배치하겠다는 소리.
                        //sub_res를 container에 배치하겠습니다.
                        R.layout.sub_res,
                        container,
                        true
                );
                CheckBox box = container.findViewById(R.id.chk);
                box.setText("Load Complete");

            }
        });
    }
}

/*
    Context란 무엇인가?

    우선 Multi Tasking과 Context Switching이라는 것을 알 필요가 있다.
    사람도 동시에 하는 것 처럼 보이지만
    아주 빠르게 하나씩 하는 것과 같다.
    컴퓨터 또한 같은 방식이다.
    (CPU는 오직 한 순간에 한가지 일만 처리한다. 컴퓨터 구조론 참고. 하지만 요즘에는 cpu가 여러개라 정말로 동시에 처리가 가능하다.)

    요즘 나오는 CPU는 대부분 2~3GHz를 지원한다.
    여기서 단위에 대한 설명이 필요하다.
    KB = 10^3 byte, MB = 10^6 byte, GB = 10^9 byte
    즉, 3GHz = 3 * 10^9 byte * 4 를 초당 처리함을 의미한다.

    그리고 이 단위는 Hz이므로 주파수를 의미한다.
    어떤 주파수의 주기는 역수로 취급한다(정의)
    그러므로 3GHz로 동작하는 CPU는 1초에 30억개의 명령을 처리할 수 있다.
    결국, 명령 1개를 처리하는데는 1/30억 초 밖에 걸리지 않는다.

    이 뜻한 하나 하나씩 아주 빠르게 처리하면,
    사람은 느끼지도 못하는 사이에 모든것이 동시에 처리되는 것 처럼 보이게 만들 수 있다는 의미다.
    이것이 컴퓨터 분야에서 이야기하는 Multi Tasking(멀티태스킹)의 정의이다.

    다음으로 Context Switching에 대한 것을 살펴보도록 한다.
    모든 프로세스는 Context를 가지고 있다.
    그리고 프로세스는 CPU의 추상화에 해당한다.
    그렇기 때문에 알 수 있는 정보가 있다. --> 결국, 프로세스는 CPU를 차지하기 위해 경쟁한다. ( 소중한 자원 == CPU)

   ( 연산 레지스터에 의해 메모리 경쟁?을 하는 것 자체가 Context Switching이다.)
    A라는 프로그램과 B라는 프로그램이 존재한다.
    A는 아래와 같은 작업을 한다.

    1 line - int a = 3;
    2 line - int c = b+a;

    B는 아래와 같은 작업을 한다.

    1 line - int a = 4;
    2 line - int d = c + a;

    위에도 언급했듯이 프로세스는 CPU를 얻기 위한 경쟁을 한다.
    (이것을 또다른 말로 스케쥴링이라 부르기도 한다.)
    가정을 해보자!

    A가 1 line을 진행하고 제어권을 B에게 빼았겼다.
    (이런식으로 제어권이 넘어가는 과정 자체를 Context Switching 이라고 한다.
    물론 , context가 보호 받는다는 가정하에)
    여기서는 context가 보호 받지 않는 다고 가정하고 이야기를 진행한다.

    B가 1 line을 진행하고 다시 스케쥴링에 의해
    제어권이 A로 넘어간 경우를 생각해보자!
    엄밀하게는 연산(범용) 레지스터에 이 정보가 저장되지만
    어셈블리어와 밀접하게 연관되어 있으므로
    우리는 a등의 변수로 설명하도록 한다.

    A가 1 line을 진행하면 a = 3이다.
    그러나 , B가 1번을 진행하면서 a=4가 된다.
    그리고 다시 A로 제어권이 넘어오면
    c= b+a를 하게 되는데 a는 3이 아니라 4다.
    그러므로 결국 의도치 않은 동작을 하게 된다.
    (이러한 것을 데이터 무결성을 훼손한다고 한다.)

    결국 이를 방어하기 위해 탄생한 기법이 Context Switching인데
    Context(연산 레지스터 , 메모리 정보 등등)을
    백업해두고 프로세스의 제어권을 다시 획득하게 될 때
    백업해놨던 context정보를 돌려주는 것이다.

    A가 1번을 진행하여 a=3이다.
    B로 제어권이 넘어가 a = 4이다.
    다시 A로 제어권이 넘어오면
    프로세스별로 저장되어 있는 context를 찾아서 돌려주므로
    A의 a= 3으로 유지한다.
    그러므로 프로그램의 동작이 영향받는 것이 없어진다.



    쓰레드 - Mutex, Semapore , Critical Section
    이 개념도 전부 Context Switching에서 온다.
    Spinlock( context switching안함 , 연산이 간단할 때 사용하는게 유리) 이라는 개념이 또한 존재하는데,
    Mutex VS Spinlock이 면접문제에 자주 등장한다.
    누가 더 좋은지를 묻는 형식으로 말이다.
    ( 결론은" 그때그때 다르다 ")
 */