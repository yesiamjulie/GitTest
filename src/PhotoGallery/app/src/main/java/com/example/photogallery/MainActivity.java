package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/*
 xml없이 작업할 때
 addView -> 마지막에 setContentView를 해주면 된다.
 */

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rC, rJava, rGo;
    Button btnOk;
    ImageView imgLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Image Gallery");

        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text2);

        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        rC= (RadioButton)findViewById(R.id.Rc);
        rJava = (RadioButton)findViewById(R.id.Rjava);
        rGo = (RadioButton)findViewById(R.id.Rgo);

        btnOk = (Button)findViewById(R.id.btnOk);

        imgLang = (ImageView) findViewById(R.id.ImgLang);



        /*
                setOnCheckedChangeListener는 setOnClickListener와 동작 방식은 유사하다.
                OnClickListener는 클릭을 했을 때 발생한다.

                OnCheckedChangeListener는 체크를 하거나 체크를 해제할 경우 동작함.
         */
        chkAgree.setOnCheckedChangeListener( // 체크박스가 변경되었을 때를 감지하고,
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged( //
                    CompoundButton buttonView,
                    boolean isChecked) {
                if (chkAgree.isChecked() == true) { // 체크박스가 체크되었을 때 동작
                    tv2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgLang.setVisibility(View.VISIBLE);

                } else { // 체크박스가 해제되었을 때의 동작 : 보이지 않게
                    tv2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgLang.setVisibility(View.INVISIBLE);
                }

            }
        });

        //버튼을 눌렀을 때 이미지 출력하기 -------->
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                      getCheckedRadioButtonId()는
                      XML리소스에 등록해놓은 id값을 판정한다.
                      이를 기반으로 setImageResource로 원하는 이미지를 띄워줄 수 있다.
                      setImageResource()를 사용할 것이라면
                      반드시 res폴더에 이미지들을 배치해야 한다.

                 */
                /*이미지는 보통 'res/drawable'에 넣고 불러옵니다.*/
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.Rc:
                        imgLang.setImageResource(R.drawable.image2);
                        break;
                    case R.id.Rjava:
                        imgLang.setImageResource(R.drawable.image3);
                        break;
                    case R.id.Rgo:
                        imgLang.setImageResource(R.drawable.image4);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Select Language!!", Toast.LENGTH_SHORT
                                );
                }
            }
        });


    }
}
/*
    문제 21. 아무런 이미지 파일을 10개정도 확보한다.
             CheckBox를 3개 만든다.

             1번째 체크박스는 오늘 작성한 예제처럼 눈에 보이게 할지 말지를 결정하도록 한다.
             2번째 체크박스는 랜덤 여부를 판정한다.
             즉,1,2번 체크박스를 체크하면, 무작위로 그림파일이 보이게 만들면 된다.
             (Button을 하나 만들어서 누를 때마다 무작위로 보이게 만들어준다.)
             3번째 체크박스는 순서대로 보이게 해준다.
             결론 :   1,2번은 무작위 출력,
                      1,3번은 순차 출력,
                      2,3번은 동작 불가능

                      1번만 있을 경우에는 visible이므로 보여주기만 함 ( 메뉴만 보여줌_)
                      2번이나 3번만 있을 경우에는 아무것도 보이지 않음.( 왜냐면 1번이 꺼져있으므로)


 */
