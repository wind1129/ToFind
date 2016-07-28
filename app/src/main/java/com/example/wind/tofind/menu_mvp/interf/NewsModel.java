package com.example.wind.tofind.menu_mvp.interf;


import com.example.wind.tofind.menu_mvp.other.NewsDetail;
import com.example.wind.tofind.menu_mvp.other.NewsItem;
import com.example.wind.tofind.menu_mvp.other.OnLoadDataListener;

/**
 * deals with the data work
 */
public interface NewsModel<I extends NewsItem, D extends NewsDetail> {

    void getNews(int type, OnLoadDataListener listener);

    //void getNewsDetail(I newsItem, OnLoadDetailListener<D> listener);

}