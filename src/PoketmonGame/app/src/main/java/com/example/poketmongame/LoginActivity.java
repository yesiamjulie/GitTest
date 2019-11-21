package com.example.poketmongame;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    EditText et_id, et_pw;
    Button login, join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        login = (Button) findViewById(R.id.btn_login);
        join = (Button) findViewById(R.id.btn_join);


        String mem_id = et_id.getText().toString();
        String mem_pw = et_pw.getText().toString();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        LoginActivity.this, JoinActivity.class
                );
                LoginActivity.this.startActivity(intent);
            }
        });
    }


        /*  조회  */
        public void queryInfo() {
            println("queryInfo() Called");


            /* 왜 try-catch 문으로 배치했나?
             *  실제 DB에 정보가 없는 상황에서 데이터에 접근하면 오류가 나는 경우를 고려하여
             *  예외 처리를 할 수 있도록 try-catch사이에 넣어 작성하였다.
             *  ( try-catch는 C언어에서 goto와 동일한 역할이다.
             *    엄밀하게는 setjmp(), longjmp()라는 두 개의 함수로 구성된다.
             *    왜냐하면,
             *    goto는 함수(메서드)간에 사용이 불가능하지만, setjmp()/ longjmp()는 저것이 불가능하다.
             *    goto를 쓰면 if-else문을 중복해서 사용하지 않아도 깔끔하게 쓸 수 있다.( 리눅스 코드 참고)*/
            try {
                String uriString = "content://com.example.sqltestfinish/info";
                Uri uri = new Uri.Builder().build().parse(uriString);

                /*조회를 할 경우에는
                 * 찾고자 하는 정보를 같이 날려주어야 한다. -> columns , getContentResolver() 함께 쓰는 이유
                 *
                 * 그러므로 아래쪽 query()에 uri와 보고자 하는 column을 같이 넘긴다.*/
                String[] columns = new String[] {"name", "age", "mobile"};

                Cursor cursor = getContentResolver().query(uri, columns, null, null, "name ASC");

                /*테이블 개수(현재 DB에 몇 명의 정보가 있는지)를 얻어온다.*/
                println("query res : " + cursor.getCount());

                int index = 0;
                /* cursor.moveToNext()는 다음 정보가 존재한다면 ! */
                while(cursor.moveToNext()) {
                    /* columns[0] 은 name이므로 name에 대한 column index를 가져오고,
                     *  이 정보를 다시 String 타입으로 변환한다.
                     *  그러므로, DB 데이블을 "name"에 있던 이름 값을 얻어오게 된다.*/
                    String name = cursor.getString(cursor.getColumnIndex(columns[0]));
                    int age = cursor.getInt(cursor.getColumnIndex(columns[1]));
                    String mobile = cursor.getString(cursor.getColumnIndex(columns[2]));

                    println("#" + index + " -> " + name + ", " + age + ", " + mobile);
                    index += 1;
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

//    public void println(String data) {
//        textView.append(data + "\n");
//    }
    public void println(String data) {

    }
}
