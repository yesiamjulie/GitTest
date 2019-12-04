package com.example.pushnotification;

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

        Button firebasecloudmessagingbtn = (Button)findViewById(R.id.messagingBtn);
        firebasecloudmessagingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.messagingBtn:
                i = new Intent(this, CloudMessageActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
