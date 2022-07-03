package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.newsapp.database.model.ArticlesItem;
import com.example.newsapp.adapter.AdapterNews;
import com.example.newsapp.database.AppDatabase;
import com.example.newsapp.network.ApiServiceProvider;
import com.example.newsapp.repository.NewsRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   MainViewModelFactory mainViewModelFactory;
   AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getInstance(getApplicationContext());

        MainViewModel viewModel=new ViewModelProvider(this,new MainViewModelFactory(new NewsRepository( ApiServiceProvider.getApiService(), database.newsDao())))
                .get(MainViewModel.class);


        viewModel.GetNews().observe(this,articles -> {
             // update UI
            RecyclerView recyclerView=findViewById(R.id.recycl_main);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            AdapterNews newsAdapter=new  AdapterNews((List<ArticlesItem>) articles);
            recyclerView.setAdapter(newsAdapter);
            Log.i(" MainActivity", "onCreate: ");
        });

        viewModel.getProgressIndicator().observe(this,mustShow ->{
            findViewById(R.id.progress_main).setVisibility(mustShow ? View.VISIBLE :View.GONE);
        });


        viewModel.getError().observe(this,error->
             Log.e("MainActivity","Error: "+error));

    }




}