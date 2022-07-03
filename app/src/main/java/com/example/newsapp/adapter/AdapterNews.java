package com.example.newsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.database.model.ArticlesItem;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {
    List<ArticlesItem> articles=new ArrayList<>();

    public AdapterNews(List<ArticlesItem> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.ViewHolder holder, int position) {
         holder.bind(articles.get(position));
         Glide.with(holder.urlToImage.getContext()).load(articles.get(position).getUrlToImage()).into(holder.urlToImage);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView author;
        private TextView title;
        private TextView publishedAt;
        private TextView content;
        private ImageView urlToImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            author=itemView.findViewById(R.id.tv_main_author);
            title=itemView.findViewById(R.id.tv_main_title);
            publishedAt=itemView.findViewById(R.id.tv_main_published);
            content=itemView.findViewById(R.id.tv_main_content);
            urlToImage=itemView.findViewById(R.id.img_main);
        }

        public void bind(ArticlesItem articles){
            author.setText(articles.getAuthor());
            title.setText(articles.getTitle());
            publishedAt.setText(articles.getPublishedAt());
            content.setText(articles.getContent());
        }
    }
}
