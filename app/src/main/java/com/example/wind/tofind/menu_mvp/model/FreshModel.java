package com.example.wind.tofind.menu_mvp.model;



import com.example.wind.tofind.menu_mvp.interf.NewsModel;
import com.example.wind.tofind.menu_mvp.other.OnLoadDataListener;
import com.example.wind.tofind.net.API;
import com.example.wind.tofind.net.DB;
import com.example.wind.tofind.net.Json;
import com.example.wind.tofind.net.Net;
import com.example.wind.tofind.ui.BaseActivity;
import com.example.wind.tofind.utils.Constants;
import com.example.wind.tofind.utils.SPUtil;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import io.realm.Realm;
import okhttp3.Call;
import okhttp3.Response;

/**
 * deals with the fresh news' data work
 */
public class FreshModel implements NewsModel<FreshPost, FreshDetailJson> {
    /**
     * clear page record to zero and start new request
     */
    public static final int TYPE_FRESH = 0;
    /**
     * a continuous request with increasing one page each time
     */
    public static final int TYPE_CONTINUOUS = 1;
    private static final String TAG = "test";
    private final Realm realm;

    private int page;
    private long lastGetTime;
    public static final int GET_DURATION = 3000;
    private BaseActivity mActivity;

    public FreshModel(BaseActivity activity) {
        mActivity = activity;
        realm = mActivity.mRealm;
    }

    @Override
    public void getNews(int type, final OnLoadDataListener listener) {

        lastGetTime = System.currentTimeMillis();
        if (type == TYPE_FRESH) {
            page = 1;//如果是全新请求，就初始化page为1
        }
        getFreshNews(listener);
    }

    private void getFreshNews(final OnLoadDataListener listener) {
        Callback<FreshJson> callback = new Callback<FreshJson>() {
            @Override
            public void onError(Call call, Exception e) {
                e.printStackTrace();
                if (System.currentTimeMillis() - lastGetTime < GET_DURATION) {
                    Net.get(API.FRESH_NEWS + page, this, API.TAG_FRESH);
                    return;
                }
                listener.onFailure("load fresh news failed");
            }

            @Override
            public void onResponse(FreshJson response) {
                if (mActivity.isFinishing() ) {
                    return;
                }
                DB.saveList(realm, response.getPosts());
                listener.onSuccess();
                page++;
                SPUtil.save(Constants.PAGE, page);
            }

            @Override
            public FreshJson parseNetworkResponse(Response response) throws IOException {
                return Json.parseFreshNews(response.body().string());
            }
        };

        Net.get(API.FRESH_NEWS + page, callback, mActivity);
    }

}
