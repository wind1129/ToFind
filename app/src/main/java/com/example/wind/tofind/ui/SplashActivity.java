package com.example.wind.tofind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.R.anim;
import android.widget.ImageView;

import com.example.wind.tofind.main_mvp.widget.MainActivity;
import com.example.wind.tofind.R;
import com.example.wind.tofind.net.API;
import com.example.wind.tofind.net.Net;
import com.example.wind.tofind.utils.Constants;
import com.example.wind.tofind.utils.DateUtil;
import com.example.wind.tofind.utils.Imager;
import com.example.wind.tofind.utils.SPUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import okhttp3.Call;

/**
 * Created by wind on 2016/7/20.
 */
public class SplashActivity extends AppCompatActivity {
    private static final String SPLASH = "splash";
    private static final int SPLASH_DURATION = 2500;

    private ImageView splash;
    private String today;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = (ImageView) findViewById(R.id.splash);

        initSplash();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(API.TAG_SPLASH);
    }

    private void initSplash() {
        today = DateUtil.parseStandardDate(new Date());
        loadImageFile();
        if (!today.equals(SPUtil.getString(Constants.DATE))) {
            getSplash();
        }
    }

    private void getSplash() {
        if (!Net.isOnline(this)) {
            return;

        } else {
            Net.get(API.SPLASH, new StringCallback() {
                @Override
                public void onError(Call call, Exception e) {

                }

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String url = jsonObject.getString("img");
                        SPUtil.save(SPLASH, url);
                        SPUtil.save(Constants.DATE, today);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, API.TAG_SPLASH);
        }
    }

    private void loadImageFile() {
        String url = SPUtil.get(SPLASH, "");
        if ("".equals(url)) {
            Imager.load(this, R.drawable.splash, splash);
        } else {
            Imager.load(url, R.anim.splash_anim, splash);
        }

        startAppDelay();
    }


    private void startAppDelay() {
        splash.postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, SPLASH_DURATION);

    }

    private void startApp() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(anim.abc_grow_fade_in_from_bottom, anim.abc_shrink_fade_out_from_bottom);
        finish();
    }
}
