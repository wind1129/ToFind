package com.example.wind.tofind;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by wind on 2016/7/20.
 */
public class ToFindAPP extends Application {
    /**
     * 全局的Context
     */
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //创建快速简洁的跨平台数据库
        setupRealm();
    }

    private void setupRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
