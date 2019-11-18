package com.example.homework24;

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



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_CODE_ENHANCE = 3;
    public static final int REQUEST_CODE_PROMOTION = 7;
    public static final int REQUEST_CODE_ITEM = 21;
    public static final int REQUEST_CODE_RANK = 77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button enhanceBtn = (Button) findViewById(R.id.enhanceBtn);
        enhanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(
                        getApplicationContext(),
                        EnhanceActivity.class
                );

                startActivityForResult( // 즉 버튼을 누를때마다 제어권이 MenuActivity.class로 넘어간다.
                        intent,
                        REQUEST_CODE_ENHANCE
                );
            }
        });


        Button promotionBtn = (Button) findViewById(R.id.promotionBtn);
        promotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(
                        getApplicationContext(),
                        PromotionActivity.class
                );

                startActivityForResult( // 즉 버튼을 누를때마다 제어권이 MenuActivity.class로 넘어간다.
                        intent,
                        REQUEST_CODE_PROMOTION
                );
            }
        });


        Button itemBtn = (Button) findViewById(R.id.itemBtn);
        enhanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(
                        getApplicationContext(),
                        ItemActivity.class
                );

                startActivityForResult( // 즉 버튼을 누를때마다 제어권이 MenuActivity.class로 넘어간다.
                        intent,
                        REQUEST_CODE_ENHANCE
                );
            }
        });


        Button rankBtn = (Button)findViewById(R.id.rankBtn);
        rankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        RankActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_RANK
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

        if(requestCode == REQUEST_CODE_ENHANCE) {
            Toast.makeText(
                    getApplicationContext(),
                    "onActivityResult Called: " + requestCode,
                    Toast.LENGTH_SHORT
            ).show();

            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                        getApplicationContext(),
                        "Response name: " + name,
                        Toast.LENGTH_SHORT
                ).show();
            }
        } else if(requestCode == REQUEST_CODE_PROMOTION) {
            Toast.makeText(
                    getApplicationContext(),
                    "onActivityResult Called: " + requestCode,
                    Toast.LENGTH_SHORT
            ).show();

            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                        getApplicationContext(),
                        "Response name: " + name,
                        Toast.LENGTH_SHORT
                ).show();
            }
        } else if(requestCode == REQUEST_CODE_ITEM) {
            Toast.makeText(
                    getApplicationContext(),
                    "onActivityResult Called: " + requestCode,
                    Toast.LENGTH_SHORT
            ).show();

            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                        getApplicationContext(),
                        "Response name: " + name,
                        Toast.LENGTH_SHORT
                ).show();
            }
        } else if(requestCode == REQUEST_CODE_RANK) {
            Toast.makeText(
                    getApplicationContext(),
                    "onActivityResult Called: " + requestCode,
                    Toast.LENGTH_SHORT
            ).show();

            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                        getApplicationContext(),
                        "Response name: " + name,
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

}




