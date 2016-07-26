package com.example.wind.tofind.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.wind.tofind.R;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by wind on 2016/7/21.
 * BaseActivity includes a base layoutId, init its toolbar (if the layout has one)
 */
public class BaseActivity extends AppCompatActivity {
    public Realm mRealm;
    protected int layoutId = R.layout.activity_base;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initLayoutId();
        super.onCreate(savedInstanceState);
        initViews();
    }


    @Override
    protected void onDestroy() {
        //取消请求
        OkHttpUtils.getInstance().cancelTag(this);
        super.onDestroy();
        //关闭realm
        mRealm.close();
    }

    protected void initViews() {
        setContentView(layoutId);
        ButterKnife.bind(this);
        mRealm = Realm.getDefaultInstance();
        initAppBar();
        //initSDK();
    }

    private void initAppBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            //决定左上角是否有返回图标
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void initLayoutId() {
    }

    public void  replaceFragment(Fragment fragment,String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main,fragment,tag);
        transaction.commit();
    }
}
