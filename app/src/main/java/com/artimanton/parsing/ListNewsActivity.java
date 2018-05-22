package com.artimanton.parsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ListNewsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String MY_LOG = "myLog";
    TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        mRecyclerView = findViewById(R.id.news_list);
        tvLog = findViewById(R.id.tvLog);


        ArrayList<News> mListNews = getIntent().getParcelableArrayListExtra("news");

        tvLog.setText(String.valueOf(mListNews.size()));
    }
}
