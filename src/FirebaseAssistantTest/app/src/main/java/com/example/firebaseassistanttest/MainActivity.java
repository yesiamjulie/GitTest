package com.example.firebaseassistanttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.firebaseassistanttest.R.id.firebaseAuthBtn;
import static com.example.firebaseassistanttest.R.id.start;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firebaseBtn = (Button)findViewById(firebaseAuthBtn);
        firebaseBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case firebaseAuthBtn:
                Intent i = new Intent(this, AuthActivity.class);
                startActivity(i);
                break;
                default:
                    break;
        }
    }
}
