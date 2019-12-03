package com.example.firebaseassistanttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Button firebaseUIBtn = (Button)findViewById(R.id.firebaseui);
        firebaseUIBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firebaseui:
                Intent i = new Intent(this, FirebaseUIActivity.class);
                startActivity(i);
                break;
                default:
                    break;
        }
    }
}
