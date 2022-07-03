package com.example.newsapp.database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.newsapp.database.model.ArticlesItem;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news_name")
    LiveData<List<ArticlesItem>> GetNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addnews(List<ArticlesItem> news);
}
