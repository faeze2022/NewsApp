package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsapp.MainViewModel;
import com.example.newsapp.repository.NewsRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory{
    NewsRepository newsRepository;

    public MainViewModelFactory(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(newsRepository);
    }
}
