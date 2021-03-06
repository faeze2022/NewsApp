package com.example.newsapp.database.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "news_name")
public class ArticlesItem{
	private String publishedAt;
	private String author;
	private String urlToImage;
	private String description;

	private Source source;
	private String title;

	@PrimaryKey
	@NonNull
	private String url;
	private String content;

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Source getSource() {
		return source;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
