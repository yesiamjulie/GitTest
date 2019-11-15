package com.example.touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {


    TextView tv;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = (TextView) findViewById(R.id.btn3);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction(); // 액션 정보 얻어오기
                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("Pressed:Down" + curX +","+ curY); // 현재 좌표를 표출함.
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("Pressed:Move" + curX + ","+ curY); // 현재 좌표를 표출함.

                } else if (action == MotionEvent.ACTION_UP) {
                    println("Pressed:Up " + curX + "," +curY);
                }

                return true;
            }
        });


        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction(); // 액션 정보 얻어오기
                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("Pressed" + curX +","+ curY); // 현재 좌표를 표출함.
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("Pressed" + curX +","+ curY); // 현재 좌표를 표출함.

                } else if (action == MotionEvent.ACTION_UP) {
                    println("Pressed " + curX + "," + curY);
                }

                return true;
            }
        });
    }

    public void println(String data){
        tv.append(data + "\n");

    }
}


/*
        숙제 25. 지금껏 배웟던 모든 내용을 총동원하여
        포켓몬 TCG 카드 게임을 만들어보자!
        온라인 기능은 필요 없다.
        튜토리얼 모드만 만들어보자!
        ( 기능 : 공격 - 평타딜, 방어, 스킬 - 맘대로 )
        상대편은 그냥 허수아비 세워놓을까? (알아서)


        ( 카드 하나로만 구현 )
 */