package com.example.advtouchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    GestureDetector detector; // 감시하는 기능 ( = Observer)




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = (TextView) findViewById(R.id.tv1);
        View v1 = (View) findViewById(R.id.view1);

//        View v3 = (View) findViewById(R.id.view3);

        v1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("Pressed" + curX + "," + curY); // 현재 좌표를 표출함.
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("Pressed" + curX + "," + curY); // 현재 좌표를 표출함.

                } else if (action == MotionEvent.ACTION_UP) {
                    println("Pressed " + curX + "," + curY);
                }

                return true;
            }

        });

        // detector는 시스템 전체를 제어할 수 있다.
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("Call onDown()");
                return true; // 사용할 때는 true값을 리턴해준다.
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("Call onShowPress()");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("Call onSingleTapUp()");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1,
                                    MotionEvent e2,
                                    float distanceX,
                                    float distanceY) {
                println("Call onScroll() " + distanceX + "," + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) { // 꾹 누르고 있을 때
                println("Call onLongPress()");

            }

            @Override
            public boolean onFling(MotionEvent e1,
                                   MotionEvent e2,
                                   float velocityX,
                                   float velocityY) {
                println("Call onFling()" + velocityX + ", " + velocityY);
                return true;
            }
        });


        View v2 = (View) findViewById(R.id.view2);

        v2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                detector.onTouchEvent(event);
                return true;
            }


        });
    }
        public void println (String data){
            tv1.append(data + "\n");


        }

    @Override

    //onKeyDown도 시스템 전체가 관장한다. 여기서의 key는 모든 키가 가능하다.
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,
                    "You Pressed [BACK] Button",
                    Toast.LENGTH_SHORT).show();
            // 추후 두번 누르면 꺼지는 기능을 구현할 수도 있음.

            return true;
        }

        return false;
    }
}

