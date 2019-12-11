package com.example.pushmessagewithfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firebasecloudmessagingbtn = (Button) findViewById(R.id.firebaseCloudMessagingBtn);
        firebasecloudmessagingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        switch (v.getId()) {
            case R.id.firebaseCloudMessagingBtn:
                i = new Intent(this, CloudMessageActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}