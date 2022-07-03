package com.example.newsapp.repository;

import androidx.lifecycle.LiveData;

import com.example.newsapp.database.model.ArticlesItem;
import com.example.newsapp.database.dao.NewsDao;
import com.example.newsapp.network.ApiService;

import java.util.List;
import io.reactivex.Completable;

public class NewsRepository {
    ApiService apiService;
    NewsDao newsDao;

    public NewsRepository(ApiService apiService, NewsDao newsDao) {
        this.apiService = apiService;
        this.newsDao = newsDao;
    }

    //this method get data from database
    public LiveData<List<ArticlesItem>> GetNews() {
        return newsDao.GetNews();
    }

    /*
      This method get updated news list from server
     single converted to Completable with ignoreElement()
     use doOnSuccess() method to save sever information to database
     */

    public Completable refresh() {
        return apiService.GetNews()
                .doOnSuccess(news -> newsDao.addnews(news.getArticles())).ignoreElement();
    }


}
