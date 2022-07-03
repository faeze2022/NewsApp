package com.example.newsapp;

import com.example.newsapp.database.model.ArticlesItem;

import java.util.List;

public class ResponseModel  {
    private int totalResults;
    private List<ArticlesItem> articles;
    private String status;

    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }

    public int getTotalResults(){
        return totalResults;
    }

    public void setArticles(List<ArticlesItem> articles){
        this.articles = articles;
    }

    public List<ArticlesItem> getArticles(){
        return articles;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}
