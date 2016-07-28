package com.example.wind.tofind.net;


import com.example.wind.tofind.main_mvp.model.RealmString;
import com.example.wind.tofind.menu_mvp.model.FreshDetailJson;
import com.example.wind.tofind.menu_mvp.model.FreshJson;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.IOException;

/**
 * Json parser util.
 */
public class Json {
    public Json() {
    }

    public static Type token = new TypeToken<RealmList<RealmString>>() {
    }.getType();


    public static Gson mGson = new GsonBuilder().
            // This is required to make Gson work with RealmObjects
                    //Gson的排除策略  通过类级别和属性级别过滤
            setExclusionStrategies(new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getDeclaringClass().equals(RealmObject.class);
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    })//Gson并不知道RealmString是一个封装的对象。。。因此让我们实现一个TypeAdapter来让它正常工作：
            .registerTypeAdapter(token, new TypeAdapter<RealmList<RealmString>>() {

                @Override
                public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {
                    // Ignore
                }

                @Override
                public RealmList<RealmString> read(JsonReader in) throws IOException, java.io.IOException {
                    RealmList<RealmString> list = new RealmList<>();
                    in.beginArray();
                    while (in.hasNext()) {
                        list.add(new RealmString(in.nextString()));
                    }
                    in.endArray();
                    return list;
                }
            }).create();

 /*   public static ZhihuJson parseZhihuNews(String latest) {
        return mGson.fromJson(latest, ZhihuJson.class);
    }

    public static ZhihuDetail parseZhihuDetail(String detail) {
        return mGson.fromJson(detail, ZhihuDetail.class);
    }*/

    public static FreshJson parseFreshNews(String fresh) {
        return mGson.fromJson(fresh, FreshJson.class);
    }

    public static FreshDetailJson parseFreshDetail(String detail) {
        return mGson.fromJson(detail, FreshDetailJson.class);
    }

    public static <Data> Data parseNews(String response, Class<Data> clz) {
        return mGson.fromJson(response, clz);
    }

}
