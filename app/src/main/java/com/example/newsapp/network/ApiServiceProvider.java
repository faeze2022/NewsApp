package com.example.newsapp.network;

import com.example.newsapp.network.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceProvider {

    private static ApiService apiService;
    //URL=https://newsapi.org/v2/everything?q=tesla&from=2022-06-05&sortBy=publishedAt&apiKey=1dc46adcaa564130a86287dd4efe009a
    private static final String BASE_URL="https://newsapi.org/v2/";


    public static ApiService getApiService() {
        if(apiService==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            apiService= retrofit.create(ApiService.class);
        }

        return apiService;
    }
}
