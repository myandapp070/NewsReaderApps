package com.example.newsreaderapps;

import android.app.Application;

import com.example.newsreaderapps.api.NewsService;
import com.example.newsreaderapps.api.RetrofitHelper;
import com.example.newsreaderapps.repository.NewsRepository;

public class NewsApplication extends Application {

    NewsRepository newsRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        NewsService newsService = RetrofitHelper.getInstance().create(NewsService.class);
        newsRepository = new NewsRepository(newsService);
    }
}
