package com.example.wind.tofind.menu_mvp.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wind.tofind.main_mvp.widget.RecyclerFragment;
import com.example.wind.tofind.main_mvp.widget.TabsFragment;
import com.example.wind.tofind.menu_mvp.other.Data;
import com.example.wind.tofind.menu_mvp.other.OnListFragmentInteract;
import com.example.wind.tofind.menu_mvp.view.NewsView;
import com.example.wind.tofind.ui.BaseActivity;

/**
 * Created by wind on 2016/7/22.
 */
public class FreshFragment extends RecyclerFragment implements SwipeRefreshLayout.OnRefreshListener,NewsView,OnListFragmentInteract{
    private BaseActivity mActivity;
    private LinearLayoutManager layoutManager;



    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        super.initView();
        mActivity = (BaseActivity) getActivity();
        type = TabsFragment.TYPE_FRESH;
        layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);

    }



    @Override
    public void onRefresh() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addNews(Data news) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadFailed(String msg) {

    }

    @Override
    public void onListFragmentInteraction(RecyclerView.ViewHolder holder) {

    }
}
