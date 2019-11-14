package com.example.activityswitching;


// Activity전환(= 화면 전환)

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static final int REQUEST_CODE_MENU = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menuBtn = (Button) findViewById(R.id.MenuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*
                    Intent는 Activity의 Context를 저장한다.
                    이전 시간에 학습한 Context Switching 개념에 입각하여
                    getApplicationContext()를 통해서
                    현재 Context를 백업하고
                    MenuActivity로 제어권을 넘기도록 Intent를 만든다.
                 */

                Intent intent = new Intent(
                        getApplicationContext(),
                        MenuActivity.class
                );
                // 현재 애플리케이션의 컨텍스트를 저장한다. => 제어권을 MenuActivity.class로 넘긴다.
                /*
                        만든 Intent를 통해 MenuActivity를 호출한다.
                        Request Code는 REQUEST_CODE_MENU가 된다.
                 */
                startActivityForResult( // 즉 버튼을 누를때마다 제어권이 MenuActivity.class로 넘어간다.
                        intent,
                        REQUEST_CODE_MENU
                );
            }
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        //RequestCode 요청이 왔을 때 처리과정
        if (requestCode == REQUEST_CODE_MENU) {

            Toast.makeText(
                    getApplicationContext(),
                    "OnActivityResult Called: " + requestCode,
                    Toast.LENGTH_SHORT
            ).show();

            if (requestCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                        getApplicationContext(),
                        "Response name: " + name, Toast.LENGTH_SHORT)
                        .show();
            }

        }
    }
}

/*
    문제24. 아래와 같은 버튼들을 만든다.
            강화, 승급, 아이템, 랭킹버튼을 누르면
            각각의 전용 Activity로 이동을 하도록 한다.
            각각의 전용 Activity에는 '나가기'버튼이 있다.
            나가기 버튼을 누르면, 원본 화면으로 복귀를 하도록 만들어보자!
            ( 오늘했던 내용보다 버튼 개수와 request_code가 늘어났다.)

            Request Code와 Result Code를
            Toast방식이 아닌 TextView로 보여주도록 하자. ( setText를 이용한다.)


 */
