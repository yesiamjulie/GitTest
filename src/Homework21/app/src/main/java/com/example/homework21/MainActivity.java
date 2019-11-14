package com.example.homework21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;



/*
    문제 21. 아무런 이미지 파일을 10개정도 확보한다.
             CheckBox를 3개 만든다.

             1번째 체크박스는 오늘 작성한 예제처럼 눈에 보이게 할지 말지를 결정하도록 한다.
             2번째 체크박스는 랜덤 여부를 판정한다.
             즉,1,2번 체크박스를 체크하면, 무작위로 그림파일이 보이게 만들면 된다.
             (Button을 하나 만들어서 누를 때마다 무작위로 보이게 만들어준다.)
             3번째 체크박스는 순서대로 보이게 해준다.
             ( chkAgree, chkRandom, chkSequence)
             결론 :   1,2번은 무작위 출력,
                      1,3번은 순차 출력,
                      2,3번은 동작 불가능

                      1번만 있을 경우에는 visible이므로 보여주기만 함 ( 메뉴만 보여줌_)
                      2번이나 3번만 있을 경우에는 아무것도 보이지 않음.( 왜냐면 1번이 꺼져있으므로)


 */

import static android.widget.LinearLayout.*;

public class MainActivity extends AppCompatActivity {

    CheckBox chk1, chk2, chk3;
    Button btn;
    ImageView imgView;
    Boolean rand = false , seq  = false;
    TextView tv1;
    int cnt = 0;

    Random random = new Random();


    int[] img = {
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,
            R.drawable.image10
    };
    int num = random.nextInt(img.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CheckList Test");

//        Ll = (LinearLayout) findViewById(R.id.back);

        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);

        tv1 = (TextView) findViewById(R.id.text);

        btn = (Button) findViewById(R.id.btnChk);

        imgView = (ImageView) findViewById(R.id.imgView);




        chk1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    // chk1은 보이게 할지 말지를 결정
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if (chk1.isChecked() == true) { // 메뉴만 보여줌

                            tv1.setVisibility(View.VISIBLE);
                            btn.setVisibility(View.VISIBLE);
                            imgView.setVisibility(View.VISIBLE);


                        } else {
                            tv1.setVisibility(View.INVISIBLE);
                            btn.setVisibility(View.INVISIBLE);
                            imgView.setVisibility(View.INVISIBLE);
                        }


                    }
                });


        chk2.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    // chk2은 랜덤여부를 결정 ( rand 변수로 결정)

                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if (chk2.isChecked() == true) { // 랜덤이미지 출력

                            rand = true;
//                                Ll.setBackgroundResource(img[num]);

                        } else {
                            rand = false;
                        }


                    }
                });


        chk3.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    // chk3은 순차출력여부 결정 ( seq 변수로 결정)

                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if (chk3.isChecked() == true) { // 랜덤이미지 출력
                            seq = true;
//                                Ll.setBackgroundResource(img[num]);
                        } else {
                            seq = false;
                        }
                    }
                });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            //클릭시 어떤 체크박스가 선택이 되어있느냐에 따라 액션이 달라짐.
            /*
                    사용자 인터페이스는 구현했으므로, 남은 작업은 각각의 체크박스에 따른
                    동작들을 만들어주면 된다.

                    단, 2번째 3번째 체크박스를 모두 선택했을 때는 오류를 줘야한다.
             */
            public void onClick(View v) {
//hls apple : 실시간 스트리밍

                if (rand == true && seq == true) {

                    tv1.setText("랜덤과 순차를 동시에 선택하셨습니다..");
//                    v.setBackgroundResource(img[num]);


                } else if (rand == true) {
                    imgView.setImageResource(
                            img[num]
                    );

                } else if (seq == true) {
                    imgView.setImageResource(
                            img[cnt++]
                    );

                    if (cnt == 10) {
                        cnt = 0;
                    }

                } else {
                    tv1.setText("올바른 설정이 필요합니다.");
                }
//                btn.setEnabled(true);

            }
        });

    }
}