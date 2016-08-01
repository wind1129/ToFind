package com.example.wind.tofind.menu_mvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.example.wind.tofind.R;
import com.example.wind.tofind.menu_mvp.model.ZhihuTop;
import com.example.wind.tofind.utils.Imager;

/**
 * Created by wind on 2016/8/1.
 */
public class BannerView implements Holder<ZhihuTop> {
    private View view;

    @Override
    public View createView(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.card_item_big, null);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, ZhihuTop entity) {
        ImageView imageView = (ImageView) view.findViewById(R.id.story_img);
        TextView textView = (TextView) view.findViewById(R.id.news_title);
        Imager.loadWithHighPriority(entity.getImage(), imageView);
        textView.setText(entity.getTitle());

    }
}
