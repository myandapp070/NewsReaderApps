package com.example.newsreaderapps.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsreaderapps.models.NewsList;
import com.example.newsreaderapps.repository.NewsRepository;

public class MainViewModel extends ViewModel {
    private NewsRepository repository;

    public MainViewModel(NewsRepository repository) {
        this.repository = repository;
            repository.getNews();
    }

    public LiveData<NewsList> getNews() {
        return repository.getNewsLiveData();
    }
}
