package com.example.activityswitching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();/*
                 Intent는 왜 비어잇을까 ? ---> finish(); 하기 때문
                 즉, Context 저장이 필요 없다. 그리고 다시 원래 Activity로 귀환할 때
                 name에 대한 값으로 back을 전달한다.
                 (되돌아가기)를 눌렀다는 의미가 된다.
                 그리고, resultCode로 RESULT_OK를 전달한다.
                */
                intent.putExtra("name", "back");// ?
                setResult(RESULT_OK, intent);

                finish();

            }
        });
    }
}
