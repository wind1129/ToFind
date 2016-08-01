package com.example.wind.tofind.menu_mvp.presenter;

import com.example.wind.tofind.menu_mvp.interf.NewsModel;
import com.example.wind.tofind.menu_mvp.model.ZhihuDetail;
import com.example.wind.tofind.menu_mvp.model.ZhihuJson;
import com.example.wind.tofind.menu_mvp.model.ZhihuModel;
import com.example.wind.tofind.menu_mvp.model.ZhihuStory;
import com.example.wind.tofind.menu_mvp.other.OnLoadDataListener;
import com.example.wind.tofind.menu_mvp.view.NewsView;
import com.example.wind.tofind.ui.BaseActivity;

/**
 * Created by wind on 2016/8/1.
 */
public class ZhihuDataPresenter implements NewsPresenter,OnLoadDataListener {
    private NewsView<ZhihuJson> mNewsView;
    private NewsModel<ZhihuStory,ZhihuDetail> mNewsModel;


    public ZhihuDataPresenter(NewsView<ZhihuJson> newsView, BaseActivity activity) {
        this.mNewsView = newsView;
        mNewsModel = new ZhihuModel(activity);
    }

    @Override
    public void loadNews() {

    }

    @Override
    public void loadBefore() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String msg) {

    }
}
