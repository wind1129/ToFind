package com.example.wind.tofind.main_mvp.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.wind.tofind.R;
import com.example.wind.tofind.ui.BaseFragment;

import butterknife.Bind;

/**
 * Created by wind on 2016/7/22.
 */
public abstract class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    @Bind(R.id.list)
    public
    RecyclerView recyclerView;//相当于listview
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    boolean isFirst = true;   //whether is first time to enter fragment
    protected int type;               // type of recyclerView's content
    int lastPosition;       //last visible position
    int firstPosition;      //first visible position




    @Override
    protected void initView() {
        recyclerView.setHasFixedSize(true);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary,
                R.color.colorPrimaryDark, R.color.colorAccent);
        swipeRefresh.setOnRefreshListener(this);

    }

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_recycler;

    }


}
