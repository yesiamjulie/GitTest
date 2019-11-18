package com.example.homework20;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


/* 문제 20. XML 없이 프로그램으로 LinearLayout 안에
            2 개의 LinearLayout 과 버튼을 배치한다.
            2 개의 LinearLayout 의 색상은 서로 다르다.
            버튼을 누르면 서로간의 색상이 교환되게 한다.
            (힌트: addView, layout_weight 의 역할을
             수행할 수 있는 매서드를 활용하면 문제 해결!
             LinearLayout.LayoutParams(
                                LayoutParams.MATCH_PARENT,
                                LayoutParams.MATCH_PARENT, 1f);)
 */

public class MainActivity extends AppCompatActivity {

    LinearLayout innerLL1;
    LinearLayout innerLL2;

    int blue = Color.rgb(0, 0, 255);
    int red = Color.rgb(255, 0, 0);

    int arr[] = {blue, red};
    int cnt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        LinearLayout base = new LinearLayout(this);
        base.setOrientation(LinearLayout.VERTICAL);
        base.setBackgroundColor(
                Color.rgb(0, 0, 255));
        setContentView(base, params);


        innerLL1 = new LinearLayout(getApplicationContext());
        innerLL1.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,1f

                )
        );
        innerLL1.setOrientation(LinearLayout.VERTICAL);
        innerLL1.setBackgroundColor(Color.rgb(255, 0, 0));



        innerLL2 = new LinearLayout(getApplicationContext());
        innerLL2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,1f

                )
        );
        innerLL2.setOrientation(LinearLayout.VERTICAL);
        innerLL2.setBackgroundColor(Color.rgb(0, 255, 0));

        base.addView(innerLL1);
        base.addView(innerLL2);

        Button btn = new Button(this);
        btn.setText("Click this button");
        btn.setBackgroundColor(Color.MAGENTA);
        base.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Change Color!",
                        Toast.LENGTH_SHORT).show();

                innerLL1.setBackgroundColor(arr[cnt++ % 2]);
                innerLL2.setBackgroundColor(arr[cnt % 2]);
            }
        });
    }

}
