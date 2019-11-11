package com.example.homework21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    CheckBox chk1, chk2, chk3;
    Button btn;
    ImageView imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CheckList Test");

        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);

        btn = (Button) findViewById(R.id.btnChk);

        imgView = (ImageView) findViewById(R.id.imgView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        chk1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if (chk1.isChecked() == true) {
                            chk1.setVisibility(View.VISIBLE);
                            chk2.setVisibility(View.VISIBLE);
                            chk3.setVisibility(View.VISIBLE);
                            btn.setVisibility(View.VISIBLE);

                        }else if(chk2.isChecked() | chk3.isChecked() == true){
                            chk1.setVisibility(View.INVISIBLE);
                            chk2.setVisibility(View.INVISIBLE);
                            chk3.setVisibility(View.INVISIBLE);
                            btn.setVisibility(View.INVISIBLE);
                        } else if (chk1.isChecked() && chk2.isChecked() == true) {
                            //무작위 출력
                        } else if (chk1.isChecked() && chk3.isChecked() == true) {
                             //순차출력

                        } else if (chk2.isChecked() && chk3.isChecked() == true) {
                            //동작불가능
                        }




                    }
                }
        );

    }
}
