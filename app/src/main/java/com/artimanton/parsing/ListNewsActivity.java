package com.artimanton.parsing;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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

        //tvLog.setText(String.valueOf(mListNews.get(1).getNameNews()));

        GridLayoutManager manager;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            manager = new GridLayoutManager(this, 2);
        }
        else{
            manager = new GridLayoutManager(this, 1);
        }

        mRecyclerView.setLayoutManager(manager);

        RVAdapter adapter = new RVAdapter(mListNews);

        mRecyclerView.setAdapter(adapter);
    }

    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NewsViewHolder>{

        List<News> mNews;

        public RVAdapter(List<News> news){
            mNews = news;
        }


        @NonNull
        @Override
        public RVAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_view, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RVAdapter.NewsViewHolder holder, int position) {
            String test = mNews.get(position).getNameNews().toString();
            String test2 = mNews.get(position).getLinkPageNews().toString();
            String test3 = mNews.get(position).getLinkImageNews().toString();


            holder.nameNews.setText(mNews.get(position).getNameNews().toString());
            holder.linkPageNews.setText(mNews.get(position).getLinkPageNews().toString());

            Picasso.get()
                    .load(mNews.get(position).getLinkImageNews().toString())
                    .fit().centerCrop()
                    .into(holder.imageNews);


        }

        @Override
        public int getItemCount() {
            return mNews.size();
        }

        public class NewsViewHolder extends RecyclerView.ViewHolder {
            ImageView imageNews;
            TextView nameNews;
            TextView linkPageNews;
            public NewsViewHolder(View itemView) {
                super(itemView);
                imageNews = itemView.findViewById(R.id.img_news);
                nameNews = itemView.findViewById(R.id.et_name_news);
                linkPageNews = itemView.findViewById(R.id.et_text_news);
            }
        }
    }
}
