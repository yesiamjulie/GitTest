package com.example.buttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
    특정 버튼을 눌렀을 때
    버튼이 응답을 하도록 해준다.
    (Event Driven 방식이라고 하며 Interrupt 라고도 한다.
    엄밀하게 이들은 사실 함수 포인터에 해당한다.
    Java 관점에서는 결국 interface에 해당한다.

    interface = 함수 포인터 = interrupt = event driven 이렇게 알아두자


    * override가 붙으면 interface
    **interface는 메소드만 있다. 이 메소드가 어떤 기능을 하는지는 개발자가 활용하는 것이다.
    *abstract는 변수와 메소드가 모두 있다.
    * Go to -> Declaration에서 활용법 보기
 */
public class MainActivity extends AppCompatActivity {
    //Button 클래스 타입의 변수 btn을 선언함
    Button btn;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //화면 생성.
        setContentView(R.layout.activity_main); //화면생성시 배치할 내용을 activity_main.xml에서 취하라.
        btn = (Button) findViewById(R.id.button);
        /*
        activity_main.xml에 있는 @+id/button을 찾아서
        해당 내용을 대표할 수 있는 정보를 btn에 저장한다. ( 포인터를 저장한다. = 주소를 저장한다.)
          (button에 대한 정보를 얻는다 -> 이것이 btn에 들어간다.)
        */


        /*
            setOnClickListener는
            btn을 클릭했을 경우 어떤 동작을 하게 만들 것인지
            '행동 지침'을 지정하는 부분이다.

            OnClickListener라는 것은 interface로
            View라는 클래스에 implements되어 있다.
            그러므로 반드시 매서드(metthod)인
            OnClick의 내용을 개발자가 직접 구현해주어야 한다.

            장점이라면 클릭시
            어떤 처리를 할지 일관되게 만들 수 있다는 것이다.

            그러나 단점은
            개발자가 이 모든 것을 제어할 수 있어야 한다는 것이다.
         */


        /*
           ### 익명 클래스란?
           원래 클래스를 사용할 때는
           A a = new A()와 같은 형태로 사용해야 한다.
           그러나 아래 코드는 'A a= ' 부분이 없어졌다.
           아래와 같이 작성하는 형태를 익명 클래스라고 한다.

           추가적인 설명으로
           SetOnClickListener가 클릭을 감시를 할 것인데
           클릭을 했을 때 어떤 동작을 취하게 만들 것인지
           행동 지침을 등록하는 부분이라고 보면 된다.
           ( 행동지침( OnClick) 을 등록하는 부분 )

           *** 인터페이스에 있는 매서드는 반드시 코드를 작성해줘야 new등의 메모리 할당이 가능하다.
           인터페이스는 코드 구현이 안되어 잇기 때문에 메모리에 할당하면서 코드를 구현해주야 사용할 수 있다.

           결론 : 이와 같은 형태는 interface를 가진 클래스를 객체화시킬 때 자주 활용하게 된다.
           그렇기에 Android에서 밥먹듯이 보게 된다.
           * 객체 : new로 할당하고 이는 메모리에 적재시키고 Heap에 등록된다.


           OnClickListener : 인터페이스 , view 클래스 안에 있는 인터페이스 ,인터페이스는 구현을 해주어야 사용 할 수 있다. 즉 메모리에 할당될 수 있다.( implements)
         */
        btn.setOnClickListener(new View.OnClickListener() { // 이것은 익명클래스, 이 경우는 인자가 객체!
            /*
               ### 익명클래스와 일반 사용 방법을 비교해보기!

                Matrix matA = new Matrix();
                //Matrix matB = new Matrix();
                //matA.addMat(matB);
                matA.addMat(new Matrix()); // 함수를 호출 할때는 stack에 저장된다.함수가 없어지면 의미가 없어지게 된다.
             */


            /*
                자동완성시 Override가 붙으면
                interface에 들어있는 메서드라 생각하면 된다.

                OnClick은 실제 클릭시 어떤 행동을 취하게 할지
                개발자가 생각한 내용을 구현하는 부분이다.


                *추후에 Activity를 만들게 되면 추가적으로 화면을 구축 할 수 있다. -> pregment ( 심화개념 : 화면을 나갔다가 들어올 때 새로 부르는 것이 아니라 저장해두었다가 가져오는 것)
             */
            @Override
            public void onClick(View v) {
                /*
                    Toast는 토스트 기기에 빵을 넣고 3분이 지나면, 구워진 빵이 튀어오른다.
                    여기서도 유사하게 메시지가 튀어오르기 때문에
                    이름을 토스트라고 붙였다고 한다.
                */

                /*
                    makeText()는 글자를 만드는 매서드다.
                    1번째 인자 getApplicationContext()는 현재 구동 중인 앱의 '모든 상태 정보'를 가져오는 메서드이다.
                    (RoundRobin : 모든 상태정보를 스위칭 한다 )

                    2번째 인자는 "토스트로 만들고 싶은 글자"

                    3번째 인자는  토스트를 얼마나 오래 띄워놓을 것인지

                    ###아래 코드 해석에 도움이 되는 부분
                    Toast.makeText(getApplicationContext(),"Pressed Button", Toast.LENGTH_SHORT)
                    이 부분 뒤쪽에 붙은 것을 보면 .show()인데 ,
                    .과 method가 있기 때문에
                    결국, 위의 코드는 클래스를 반환한다는 의미이다.

                    그렇다면 makeText는 무엇을 반환한다는 것일까? 정의를 들어가보자.
                    public static Toast makeText(Context context, CharSequence text,....)
                    매서드의 프로토타입을 보면 리턴타입, 인자 등을 확인할 수 있다.
                    결국, Toast를 반환(return)한다는 의미이다.

                    ##프로토타입이란?
                    매서드(함수)의 리턴, 이름 , 인자 등등을 의미함.
                    결국 입력, 출력을 보겠다는 의미

                    매서드의 프로토타입을 보면
                    리턴타입, 인자 등을 확인할 수 있는데
                    결론은 Toast를 리턴(반환)한다는 것을 알 수 있다.

                    show()는 작성한 내용을 화면에 출력해준다.
                    실제 show()가 toast안에 잇는지 확인해보자 . (Declation에서 확인하면 이를 확인할 수 있다.)
                 */
                Toast.makeText(getApplicationContext(),"Pressed Button", Toast.LENGTH_SHORT).show();

                /*
                    ######Event Driven 방식(Interrupt)(이)란?
                    1.  모든 Event Driven 방식은
                        어떠한 경우에도 반드시 운영체제가 실행한다.
                    2.  사용자(개발자)는 행동 지침만을 결정한다.
                        (사용자 - User, 운영체제 - Kernel)
                    3.  특정 상황(Event - 이벤트)이 발생하면,
                        운영체제가 지정된 행동 지침을 실행한다.
                 */
            }
        });
        tv = (TextView) findViewById(R.id.resText);
        tv.setText("잘.되.네.?");
    }

    /*
    숙제 19:
            두 개의 Button을 만듭니다.
            Layout은 LinearLayout으로 만듭니다.
            그나마 보기 좋게 orientation=vertical로 만듭니다.
            오늘 배운 padding도 적용해주세요.

            TextView를 1개 만듭니다.
            1번째 버튼을 누르면 Toast메세지 출력
            2번째 버튼을 누르면 TextView의 글자를 변경

    (Hint.
        리스너가 두개 필요함
        버튼 2개
        1. 토스트 메시지 출력
        2. 텍스트뷰에 텍스트 출력 : Onclick안에서 처리합니다.)
    */
}
