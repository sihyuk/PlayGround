package com.example.androidplayground.Model;

public class ModelItem {


private int imageResources;
private String title;

    public ModelItem(int imageResources, String title) {
        this.imageResources = imageResources;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResources() {
        return imageResources;
    }
}

