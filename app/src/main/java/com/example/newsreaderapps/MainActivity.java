package com.example.newsreaderapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsreaderapps.adapters.NewsAdapter;
import com.example.newsreaderapps.repository.NewsRepository;
import com.example.newsreaderapps.viewmodel.MainViewModel;
import com.example.newsreaderapps.viewmodel.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsRecyclerView;
    private NewsAdapter adapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = findViewById(R.id.news_recycler_view);
        NewsRepository repository = ((NewsApplication) getApplication()).newsRepository;
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(repository)).get(MainViewModel.class);

        mainViewModel.getNews().observe(this, news -> {
            adapter = new NewsAdapter(this, news.getArticles());
            newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            newsRecyclerView.setAdapter(adapter);
        });
    }
}