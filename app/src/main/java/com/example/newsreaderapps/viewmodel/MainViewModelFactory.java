package com.example.newsreaderapps.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsreaderapps.repository.NewsRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private NewsRepository repository;

    public MainViewModelFactory(NewsRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(repository);
    }
}
