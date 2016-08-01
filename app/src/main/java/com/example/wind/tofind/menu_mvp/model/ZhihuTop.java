package com.example.wind.tofind.menu_mvp.model;

import io.realm.RealmObject;

/**
 * Created by wind on 2016/8/1.
 */
public class ZhihuTop extends RealmObject{
    private int id;
    private String title;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
