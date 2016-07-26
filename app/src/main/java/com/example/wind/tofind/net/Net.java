package com.example.wind.tofind.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by wind on 2016/7/20.
 */
public class Net {
    public static boolean isOnline(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo.isConnected() && networkInfo != null);
    }

    ;


    public static void get(String url, Callback callback, Object tag) {
        OkHttpUtils.get().url(url).tag(tag)
                .build().execute(callback);
    }
}
