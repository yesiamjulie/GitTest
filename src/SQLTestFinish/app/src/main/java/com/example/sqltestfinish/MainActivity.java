package com.example.sqltestfinish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* 버튼 이벤트 처리 Handler 구현 부분*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);

        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertInfo();
            }
        });

        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryInfo();
            }
        });

        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInfo();
            }
        });

        Button button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInfo();
            }
        });
    }

    public void insertInfo() {
        println("insertInfo() Called");


        /*주의
        * content://까지는 동일하게 쓴다.
        * 그 다음이 패키지 정보가 배치된다. 여기서 패키지 정보는 com.example.sqltestfinish/( 프로젝트(패키지)명에 따라 달라질 수 있다.)
        * 마지막 부분인 info는 DB이름을 info.db로 만들 때를 뜻한다.*/
        String uriString = "content://com.example.sqltestfinish/info";

        /*아래 코드를 통해 실제 DB에 대한 정보를 해석할 준비를 함을 뜻한다.
        * parse : 파싱한다. 디비 파일에 등록된 정보들을 파싱해서 적절하게 사용할 수 있는 형태를 가지고 있는 것.*/
        Uri uri = new Uri.Builder().build().parse(uriString);

        /*DB 테이블에 있는 컬럼 이름들을 가져온다.
        * 테이블 구조를 해석한다.*/
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        String[] columns = cursor.getColumnNames();

        /*columns.length : 테이블에 몇 개의 요소가 있는지를 나타냄.*/
        println("columns count -> " + columns.length);
        for (int i = 0; i < columns.length; i++) {
            println("#" + i + " : " + columns[i]);
        }

        /*ContentValues는 실제 테이블에 데이터를 넣는 작업을 지원해준다.
        * ContentValues의 객체인 values.put()을 통해서 이를 수행한다.
        * 첫 번째 인자는 컬럼 이름 , 두 번째 인자에 컬럼에 넣을 '값'을 설정해주면 된다.*/
        ContentValues values = new ContentValues();
        values.put("name", "Jessica");
        values.put("age", 20);
        values.put("mobile", "010-3333-7777");

        /*최종적으로 DB에 값을 넣는 작업을 수행한다.*/
        uri = getContentResolver().insert(uri, values);
        println("insert 결과 -> " + uri.toString());
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

    /* update : 개인 정보 변경 부분 */
    public void updateInfo() {
        println("updateInfo() Called");

        String uriString = "content://com.example.sqltestfinish/info";
        Uri uri = new Uri.Builder().build().parse(uriString);


        /*Selection 에는 DB 테이블상에서 변경을 적용할 대상을 적는다.
        * 예를 들어, 휴대폰 번호를 바꾸는 상황이라면,
        * mobile = ? 를 적어줘야 한다.
        *
        * 본래 SQL은 명령이 들어오면 바로바로 처리한다.
        * 그러나 '?'가 있을 경우에는 값이 채워지기까지 대기한 후에
        * 처리할 수 있는 형식의 구조를 지원하게 된다.
        * */
        String selection = "mobile = ?";

        /* selectionArgs는 mobile이라는 컬럼 이름에서
        *  해당 번호(010-3333-7777)를 가진 대상을 찾기 위해 적은 것이다.
        * 만약  다른 내용을 찾고자 한다면 찾고자하는 정보를 여기에 적으면 된다.
        *
        * 필요하다면 DB Query를 사용해도 무방하다.*/
        String[] selectionArgs = new String[]{"010-3333-7777"};

        /* 값( mobile) 을 특정한 값(010-3333-7777)을 변경하고자 사용하는 코드  */
        ContentValues updateValue = new ContentValues();
        updateValue.put("mobile", "010-3377-2473");

        int count = getContentResolver().update(uri, updateValue, selection, selectionArgs);
    println("update res : " + count);
}


    /* 탈퇴 혹은 밴( 블랙 ) 기능 */
    public void deleteInfo() {
        println("deleteInfo() Called");

        String uriString = "content://com.example.sqltestfinish/info";
        Uri uri = new Uri.Builder().build().parse(uriString);

        String selection = "name = ?";
        String[] selectionArgs = new String[] {"Jessica"};

        int count = getContentResolver().delete(uri, selection, selectionArgs);
        println("delete res : " + count);
    }

    public void println(String data) {
        textView.append(data + "\n");
    }
}
