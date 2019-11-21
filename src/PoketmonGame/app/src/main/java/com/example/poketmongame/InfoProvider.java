package com.example.poketmongame;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

//import android.annotation.Nullable;

public class InfoProvider extends ContentProvider {
    private static final String AUTHORITY = "com.example.sqltestfinish";
    private static final String BASE_PATH = "info";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    private static final int INFOS = 1;
    private static final int INFO_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, INFOS);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", INFO_ID);
    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        DBHelper helper = new DBHelper(getContext());
        database = helper.getWritableDatabase();

        return true;
    }


    /* 이 부분은 MainActivity에
    *  Cursor cursor = getContentResolver().query(uri, columns, null, null, "name ASC");
    *  위 부분에 해당한다.
    *
    *  인자로 넘어온 name ASC 는 이름을 기준으로 '오름차순'정렬을 의미한다.*/
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case INFOS:

                /*첫번째는 테이블 이름
                * 두번째는 테이블 내에 모든 컬럼
                * 세번째는 s인데 , 결국 Query이므로 없음
                * 네번째부터 여섯번째가지 null
                * 마지막은 정렬기준을 적으면 된다.( 현재 우리 입장에서 nameASC에 따라 이름을 기준으로 오름차순 작업을 진행한다. )*/
                cursor =  database.query(DBHelper.TABLE_NAME, DBHelper.ALL_COLUMNS,
                        s, null, null, null, DBHelper.INFO_NAME + " ASC");
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case INFOS:
                return "vnd.android.cursor.dir/infos";
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }



    /*
       MainActivity에 아래 부분에 해당한다.
    *  uri = getContentResolver().insert(uri, values);

   */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        /* 첫번째 인자 : 테이블 이름
        *  두번째 인자 : null,
        *  세번째 인자 : contentValues로
        *  실제 컬럼과 각 컬럼에 들어갈 데이터에 해당한다. */
        long id = database.insert(DBHelper.TABLE_NAME, null, contentValues);

        if (id > 0) {

            /* Content URI라는 것은 결국,
               'content://com.example.sqltestfinish/info' 을 의미한다.
               아래부분에서는 몇 번 바뀌었는지를 볼 수 있다고 판단하면 된다.

            * */
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }

        throw new SQLException("Add Fail -> URI :" + uri);
    }


    /* MainActivity에 있는 getcontentResolver().delete()에 해당한다. */
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int count = 0;

        /* DB가 "content://com.example.sqltestfinish/info" 에 존재한다면,
        * 무조건 uriMatcher.match의 결과는 1d이다*/
        switch (uriMatcher.match(uri)) {
            case INFOS:

                /* 실제 DB를 delete 하는 작업이 진행되는 부분이다.
                *
                *  첫번째 인자는 TABLE_NAME, 두번째 인자(name)는 무엇을 기반으로 지울 것인지,
                *  세번째 인자(Jessica)는 무엇이 되는 대상
                *  즉, 이름이 Jessica인 모든 정보를 지워라! */
                count =  database.delete(DBHelper.TABLE_NAME, s, strings);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }

    /* MainActivity에서 있는
    *  getContentResolver().update(uri, updateValue, selection, selectionArgs)
    *  이 코드에서 update에 해당한다.*/
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case INFOS:

                /* 첫번째 인자는 테이블 이름 (info)
                *  두번째 인자는 "mobile", "010-3377-2473" 으로
                *  폰 번호를 010-3333-7777으로 바꿀려하는 것
                *  세번째 인자는 무엇(mobile)을 update하려고 하는가
                *  네번째 , 세번째 인자의 세부사항
                *  즉 , mobile인데 010-3333-7777인 것을 변경하겟다는 의미이다.*/
                count =  database.update(DBHelper.TABLE_NAME, contentValues, s, strings);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }
}
