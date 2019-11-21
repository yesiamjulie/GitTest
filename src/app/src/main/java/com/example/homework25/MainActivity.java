package com.example.homework25;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.text.method.HideReturnsTransformationMethod;
        import android.text.method.PasswordTransformationMethod;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.example.homework25.ui.login.LoginActivity;

        import java.security.KeyStore;

        /*
        숙제 25. 지금껏 배웟던 모든 내용을 총동원하여
        포켓몬 TCG 카드 게임을 만들어보자!
        온라인 기능은 필요 없다.
        튜토리얼 모드만 만들어보자!
        ( 기능 : 공격 - 평타딜, 방어, 스킬 - 맘대로 )
        상대편은 그냥 허수아비 세워놓을까? (알아서)


        ( 카드 하나로만 구현 )
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout manager = new LinearLayout(this);
        LinearLayout.LayoutParams params = new  LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

        );
        manager.setOrientation(LinearLayout.VERTICAL);
        manager.setPadding(5,5,5,5);
        manager.setGravity(Gravity.CENTER);

        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        EditText et1 = new EditText(this);
        EditText et2 = new EditText(this);
        Button bt1 = new Button(this);
        Button bt2 = new Button(this);


        tv1.setText("ID");
        tv1.setGravity(Gravity.LEFT);
//        et1.setGravity(Gravity.CENTER);
        et2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        tv2.setText("PW");
        tv2.setGravity(Gravity.LEFT);
        bt1.setGravity(Gravity.CENTER);
        bt2.setGravity(Gravity.CENTER);
        bt1.setText("Login");
        bt1.setBackgroundColor(Color.BLUE);
        bt1.setTextColor(Color.WHITE);
        bt2.setTextColor(Color.WHITE);
        bt2.setText("Join Member");
        bt2.setBackgroundColor(Color.MAGENTA);
        params.setMargins(10,0,0,20);

        manager.addView(tv1, params);
        manager.addView(et1, params);
        manager.addView(tv2, params);
        manager.addView(et2,params);
        manager.addView(bt1,params);
        manager.addView(bt2,params);
        setContentView(manager);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 성공시

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
