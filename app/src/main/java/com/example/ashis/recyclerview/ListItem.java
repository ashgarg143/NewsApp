package com.example.ashis.recyclerview;

public class ListItem {
    private String title;
    private String desc;
    private String imageUrl;
    private String source;
    private String newsUrl;

    public ListItem(String title, String desc, String imageUrl, String source, String newsUrl) {
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.source = source;
        this.newsUrl = newsUrl;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSource() {
        return source;
    }

    public String getNewsUrl() {
        return newsUrl;
    }
}
