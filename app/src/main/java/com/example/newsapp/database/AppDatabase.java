package com.example.newsapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.newsapp.database.model.ArticlesItem;
import com.example.newsapp.database.dao.NewsDao;

@Database(entities = {ArticlesItem.class}, exportSchema = false, version = 1)
@TypeConverters(SourceTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "news").allowMainThreadQueries().build();
        }

        return appDatabase;
    }
}
