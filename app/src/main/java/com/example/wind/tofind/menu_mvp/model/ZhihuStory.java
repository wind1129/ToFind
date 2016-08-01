package com.example.wind.tofind.menu_mvp.model;

import com.example.wind.tofind.menu_mvp.other.NewsItem;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by wind on 2016/8/1.
 */
public class ZhihuStory extends RealmObject implements NewsItem {
    @PrimaryKey
    private int id;
    private int type;
    private String title;
    private RealmList<RealmString> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<RealmString> getImages() {
        return images;
    }

    public void setImages(RealmList<RealmString> images) {
        this.images = images;
    }
}
