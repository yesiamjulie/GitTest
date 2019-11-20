package com.example.poketmongame;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    EditText et_id, et_pw;
    Button login, join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        login = (Button) findViewById(R.id.btn_login);
        join = (Button) findViewById(R.id.btn_join);


        String mem_id = et_id.getText().toString();
        String mem_pw = et_pw.getText().toString();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),JoinActivity.class
                );
               startActivity(intent);
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), JoinActivity.class
                );
                startActivity(intent);
            }
        });
    }
}
