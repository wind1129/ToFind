package com.example.wind.tofind.menu_mvp.model;

import com.example.wind.tofind.menu_mvp.interf.NewsModel;
import com.example.wind.tofind.menu_mvp.other.OnLoadDataListener;
import com.example.wind.tofind.net.API;
import com.example.wind.tofind.net.Net;
import com.example.wind.tofind.ui.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import io.realm.Realm;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by wind on 2016/8/1.
 */
public class ZhihuModel implements NewsModel<ZhihuStory,ZhihuDetail> {
    private BaseActivity mActivity;
    private Realm realm;
    private int type;//type用来选择是latest还是before


    public ZhihuModel(BaseActivity activity) {
        mActivity = activity;
        realm = mActivity.mRealm;
    }

    @Override
    public void getNews(int type, OnLoadDataListener listener) {
        this.type = type;

        Callback<ZhihuJson> callback = new Callback<ZhihuJson>() {
            @Override
            public ZhihuJson parseNetworkResponse(Response response) throws Exception {
                return null;
            }

            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(ZhihuJson response) {

            }
        };

        getData(callback);
    }

    private void getData(Callback<ZhihuJson> callback) {
        if (type == API.TYPE_LATEST) {
            Net.get(API.NEWS_LATEST, callback, mActivity);
        }
    }
}
