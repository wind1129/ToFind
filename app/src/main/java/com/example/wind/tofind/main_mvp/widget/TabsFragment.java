package com.example.wind.tofind.main_mvp.widget;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import com.example.wind.tofind.R;
import com.example.wind.tofind.menu_mvp.widget.ZhihuFragment;
import com.example.wind.tofind.menu_mvp.widget.FreshFragment;
import com.example.wind.tofind.ui.BaseFragment;
import com.example.wind.tofind.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by wind on 2016/7/22.
 */
public class TabsFragment extends BaseFragment {
    public static final int TYPE_ZHIHU = 1024;
    public static final int TYPE_FRESH = 1025;

    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.tabs)
    TabLayout tabs;

    public static final String MENU_NEWS = "news";
    public static final String MENU_PIC = "pic";

    private List<RecyclerFragment> fragments = new ArrayList<>();

    private String menuType;

    private TabPagerAdapter pagerAdapter;

    public static TabsFragment newInstance(String type) {
        Bundle args =new Bundle();
        args.putString(Constants.TYPE,type);
        TabsFragment tabsFragment = new TabsFragment();
        tabsFragment.setArguments(args);
        return  tabsFragment;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        pagerAdapter = new TabPagerAdapter(getChildFragmentManager());
        initFragments();
        pager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(pager);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initFragments() {
        menuType = getArguments().getString(Constants.TYPE);
        List<String> mTitles;
        if(MENU_NEWS.equals(menuType)){
            mTitles = new ArrayList<>();
            fragments.add(new ZhihuFragment());
            fragments.add(new FreshFragment());
            mTitles.add(getString(R.string.zhihu_news));
            mTitles.add(getString(R.string.fresh_news));
            pagerAdapter.setFragments(fragments,mTitles);
        }




    }

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_news_tab;

    }

    public static class TabPagerAdapter extends FragmentPagerAdapter {
        private List<RecyclerFragment> fragments;
        private List<String> titles;

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setFragments(List<RecyclerFragment> fragments,List<String> titles){
            this.fragments = fragments;
            this.titles = titles;

        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public float getPageWidth(int position) {
            return super.getPageWidth(position);
        }

    }
}
