package com.example.newsapp.network;

import com.example.newsapp.ResponseModel;

import io.reactivex.Single;

import retrofit2.http.GET;

public interface ApiService {

    @GET("everything?q=tesla&from=2022-05-30&sortBy=publishedAt&apiKey=1dc46adcaa564130a86287dd4efe009a")
    Single<ResponseModel>GetNews();
}
