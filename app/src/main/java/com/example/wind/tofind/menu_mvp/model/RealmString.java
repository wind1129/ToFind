package com.example.wind.tofind.menu_mvp.model;

import io.realm.RealmObject;

/**
 * Created by wind on 2016/8/1.
 * To make realmObject 'support' List<String>
 */
public class RealmString extends RealmObject {
    private String val;

    public RealmString(String val) {
        this.val = val;
    }

    public RealmString() {
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
