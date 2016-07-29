package com.example.wind.tofind.main_mvp.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.wind.tofind.R;
import com.example.wind.tofind.ui.BaseFragment;
import com.example.wind.tofind.utils.Constants;
import com.example.wind.tofind.utils.SPUtil;

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
    protected int firstPosition;      //first visible position




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


    public void showProgress(final boolean refreshState) {
        if (null != swipeRefresh) {
            swipeRefresh.setRefreshing(refreshState);
        }
    }


    @Override
    //Fragment对象可见，但不可交互。有Activity对象转为onPause状态时调用
    public void onPause() {
        super.onPause();
        SPUtil.save(type + Constants.POSITION, firstPosition);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
