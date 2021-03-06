package com.example.wind.tofind.menu_mvp.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wind.tofind.main_mvp.widget.RecyclerFragment;
import com.example.wind.tofind.main_mvp.widget.TabsFragment;
import com.example.wind.tofind.menu_mvp.other.Data;
import com.example.wind.tofind.menu_mvp.other.NewsListAdapter;
import com.example.wind.tofind.menu_mvp.other.OnListFragmentInteract;
import com.example.wind.tofind.menu_mvp.other.ZhihuListAdapter;
import com.example.wind.tofind.menu_mvp.presenter.FreshDataPresenter;
import com.example.wind.tofind.menu_mvp.presenter.NewsPresenter;
import com.example.wind.tofind.menu_mvp.presenter.ZhihuDataPresenter;
import com.example.wind.tofind.menu_mvp.view.NewsView;
import com.example.wind.tofind.ui.BaseActivity;

/**
 * Created by wind on 2016/7/22.
 */
public class ZhihuFragment extends RecyclerFragment implements SwipeRefreshLayout.OnRefreshListener,NewsView,OnListFragmentInteract {


    private ZhihuListAdapter adapter;
    private LinearLayoutManager layoutManager;
    private NewsPresenter presenter;
    private BaseActivity mActivity;


    @Override
    protected  void  initView(){
        super.initView();
        type = TabsFragment.TYPE_ZHIHU;

        mActivity = (BaseActivity) getActivity();

        layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ZhihuListAdapter(this,mActivity);
        recyclerView.setAdapter(adapter);


    }


    @Override
    protected void initData() {
        presenter = new ZhihuDataPresenter(this, (BaseActivity) getActivity());

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

    @Override
    public void onRefresh() {

    }


}
