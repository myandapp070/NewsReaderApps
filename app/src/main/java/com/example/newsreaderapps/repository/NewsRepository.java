package com.example.newsreaderapps.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsreaderapps.api.NewsService;
import com.example.newsreaderapps.models.NewsList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static final String TAG = "NewsRepository";
    private NewsService mNewsService;
    private MutableLiveData<NewsList> newsLiveData = new MutableLiveData<>();

    public NewsRepository(NewsService newsService) {
        this.mNewsService = newsService;
    }

    public void getNews() {
        Call<NewsList> news = mNewsService.getNews("in");
        news.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if (response != null && response.body() != null) {
                    newsLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d(TAG, "Error in Fetching News", t);
            }
        });
    }

    public LiveData<NewsList> getNewsLiveData() {
        return newsLiveData;
    }
}
