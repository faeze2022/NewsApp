package com.example.newsapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.database.model.ArticlesItem;
import com.example.newsapp.repository.NewsRepository;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> error=new MutableLiveData<>();
    private MutableLiveData<Boolean> progressIndicator=new MutableLiveData<>();
    private MutableLiveData<List<ArticlesItem>>articles;
    private Disposable disposable;
    NewsRepository newsRepository;

    public MainViewModel( NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        progressIndicator.setValue(true);
        newsRepository.refresh().subscribeOn(Schedulers.io())
           .doFinally(()->progressIndicator.postValue(true))
           .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable=d;

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        error.postValue("خطای نامشخص");
                        Log.e("refresh error", e.toString());

                    }
          });
    }


     public LiveData<List<ArticlesItem>> GetNews() {

        return newsRepository.GetNews();
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> getProgressIndicator() {
        return progressIndicator;
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
