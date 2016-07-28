package com.example.wind.tofind.menu_mvp.presenter;


import com.example.wind.tofind.menu_mvp.interf.NewsModel;
import com.example.wind.tofind.menu_mvp.model.FreshDetailJson;
import com.example.wind.tofind.menu_mvp.model.FreshJson;
import com.example.wind.tofind.menu_mvp.model.FreshModel;
import com.example.wind.tofind.menu_mvp.model.FreshPost;
import com.example.wind.tofind.menu_mvp.other.OnLoadDataListener;
import com.example.wind.tofind.menu_mvp.view.NewsView;
import com.example.wind.tofind.ui.BaseActivity;

/**
 * helps to present fresh news list
 */
public class FreshDataPresenter implements NewsPresenter, OnLoadDataListener {
    private NewsView<FreshJson> mNewsView;
    private NewsModel<FreshPost, FreshDetailJson> mNewsModel;

    public FreshDataPresenter(NewsView<FreshJson> newsView, BaseActivity activity) {
        this.mNewsView = newsView;
        mNewsModel = new FreshModel(activity);
    }

    @Override
    public void loadNews() {
        mNewsView.showProgress();
        mNewsModel.getNews(FreshModel.TYPE_FRESH, this);
    }

    @Override
    public void loadBefore() {
        mNewsView.showProgress();
        mNewsModel.getNews(FreshModel.TYPE_CONTINUOUS, this);

    }

    @Override
    public void onSuccess() {
        mNewsView.addNews(null);
        mNewsView.hideProgress();
    }

    @Override
    public void onFailure(String msg) {
        mNewsView.hideProgress();
        mNewsView.loadFailed(msg);
    }
}
