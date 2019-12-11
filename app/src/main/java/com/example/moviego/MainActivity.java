package com.example.moviego;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    ArrayList<Movie> movieList;
    public String movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        movieList = new ArrayList<Movie>();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Asynctask - OKHttp

    //    "test" + name + "gogo"
      String search_url = "https://api.themoviedb.org/3/search/movie?api_key=a44fcf5e3683837e95de61bdf5f04a03&query=movie&language=ko-KR&page=1";
       // String search_url = "https://api.themoviedb.org/3/search/movie?api_key=a44fcf5e3683837e95de61bdf5f04a03&query="+movieName+"&language=ko-KR&page=1";
        String[] strings = {search_url};
        MyAsyncTask mAsyncTask = new MyAsyncTask();
        mAsyncTask.execute(strings[0]);

//        MyAsyncTask mAsyncTask = new MyAsyncTask();
//        mAsyncTask.execute();

        //LayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }

    public class MyAsyncTask extends AsyncTask<String, Void, Movie[]> {
        //로딩중 표시
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("로딩중...");
            //show dialog
            progressDialog.show();

            // 목록 배열 정렬
            movieList.clear();
        }

        @Override
        protected Movie[] doInBackground(String... strings) {
            Log.d("AsyncTask", "url : " + strings[0]);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(strings[0])
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Gson gson = new GsonBuilder().create();
                JsonParser parser = new JsonParser();
                JsonElement rootObject = parser.parse(response.body().charStream())
                        .getAsJsonObject().get("results");
                Movie[] posts = gson.fromJson(rootObject, Movie[].class);
                return posts;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Movie[] result) {
            super.onPostExecute(result);
            progressDialog.dismiss();


            //ArrayList에 차례대로 집어 넣는다.
            if (result.length > 0) {
                for (Movie p : result) {
                    movieList.add(p);
                }
            }

            //어답터 설정
            adapter = new MyRecyclerViewAdapter(MainActivity.this, movieList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("영화제목을 입력하세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //검색어를 다 입력하고 서치 버튼을 눌렀을때

            @Override
            public boolean onQueryTextSubmit(String movieName) {

                Toast.makeText(MainActivity.this, movieName + "에 대한 영화를 검색합니다.", Toast.LENGTH_LONG).show();
                //여기서 AsyncTask를 이용 검색 리퀘스트로 데이터를 받아 오게 처리 하자. - AsyncTask 공유할것.
                return false;
            }

            //검색 입력창에 새로운 텍스트가 들어갈때 마다 호출 - 여기선 필요 없음
            @Override
            public boolean onQueryTextChange(String s) {
                //Log.d("Search", "keyword: " + s);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                Toast.makeText(this, "action_search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "앱설정-준비중", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this, "default", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }



}
