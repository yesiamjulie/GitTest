package com.example.poketmongame;

//import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        setTitle("JoinMember");

        EditText join_id = (EditText) findViewById(R.id.join_id);
        EditText join_pw = (EditText) findViewById(R.id.join_pw);
        EditText join_pw2 = (EditText) findViewById(R.id.join_pw_overlap);
        EditText join_name = (EditText) findViewById(R.id.join_name);
        EditText join_mobile = (EditText) findViewById(R.id.join_phone);
        RadioButton female = (RadioButton)findViewById(R.id.female);
        RadioButton man = (RadioButton)findViewById(R.id.man);
        Button join = (Button) findViewById(R.id.join_btn);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"회원가입 완료!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                JoinActivity.this.startActivity(intent);
            }
        });
    }
}
