package com.example.homework23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;



/*
        문제 22 . 오늘 우리는 Activity를 동적으로 추가하는 방법을 배웠다.
                  LayoutInflater를 통해 Context도 관리 할 수 있다.
                  XML의 도움 없이 버튼을 누르면
                  계속 LinearLayout이 추가되도록
                  오늘의 예제 프로그램을 개조해보자!
                  ( 오늘 배운것 + 저번 과제에서 코드로 Linearlayout을 추가했던 부분을 참고해보자.)

 */

public class MainActivity extends AppCompatActivity {
    final int CONTAINER = 10000;
    final int CHK = 20000; // ?

    final int MAX_LAYOUT = 100;
    LinearLayout[] container = new LinearLayout[MAX_LAYOUT];

    LinearLayout base;

    int cnt = 0;

    public void makeSubScene(){
        //inflater 역할 수행
        //Linearlayout 만든 예제 참고
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        container[cnt] = new LinearLayout(this);
        container[cnt].setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("Sub Scene");

        CheckBox chk = new CheckBox(this);
        chk.setText("Load Complete");

        container[cnt].addView(tv);
        container[cnt].addView(chk);
        container[cnt].setId(CONTAINER + cnt); // ?
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);



        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
        base = new LinearLayout(this);
        base.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("Press Button to add Scene");


        Button btn = new Button(this);
        btn.setText("Button");

        base.addView(tv);
        base.addView(btn);

        setContentView(base,params);

        btn.setOnClickListener(new View.OnClickListener() { // 버튼이 눌릴 때 실행되는 Action
            @Override
            public void onClick(View v) {

                makeSubScene();
                base.addView(container[cnt++]);

            }
        });
    }
}