package com.example.wind.tofind.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wind.tofind.ToFindAPP;

/**
 * Glide加载图片的工具类
 * loading img encapsulation.
 */
public class Imager {

    public static void load(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(view);
    }

    public static void load(Context context, int resourceId, ImageView view) {
        Glide.with(context)
                .load(resourceId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(view);
    }

    public static void loadWithHighPriority(String url, ImageView view) {
        Glide.with(ToFindAPP.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //指定加载的优先级
                .priority(Priority.HIGH)
                .into(view);
    }

    public static void load(String url, int animationId, ImageView view) {
        Glide.with(ToFindAPP.context)
                .load(url)
                //在异步加载资源完成时执行该动画
                .animate(animationId)
                //设置缓存策略，缓存source和result
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

}
