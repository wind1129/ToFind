package com.example.wind.tofind.menu_mvp.view;


import com.example.wind.tofind.menu_mvp.other.Data;

/**
 * fragment or activity need to implement this to show news list.
 */
public interface NewsView<T extends Data> {
    void showProgress();
    void addNews(T news);
    void hideProgress();
    void loadFailed(String msg);
}
