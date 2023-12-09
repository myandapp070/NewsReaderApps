package com.example.newsreaderapps.api;

import com.example.newsreaderapps.models.NewsList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsService {
    public static final String API_KEY = "d5a7b56c9b8246a3859a857d7d254a3d";
    @GET("/v2/top-headlines?apiKey=" + API_KEY)
    Call<NewsList> getNews(@Query("country") String country);

}
