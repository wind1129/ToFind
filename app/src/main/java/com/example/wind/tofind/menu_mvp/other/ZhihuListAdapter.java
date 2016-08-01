package com.example.wind.tofind.menu_mvp.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.example.wind.tofind.R;
import com.example.wind.tofind.menu_mvp.model.ZhihuStory;
import com.example.wind.tofind.menu_mvp.model.ZhihuTop;
import com.example.wind.tofind.menu_mvp.view.BannerView;
import com.example.wind.tofind.menu_mvp.view.NewsView;
import com.example.wind.tofind.menu_mvp.widget.ZhihuFragment;
import com.example.wind.tofind.net.DB;
import com.example.wind.tofind.ui.BaseActivity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by wind on 2016/7/29.
 */
public class ZhihuListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RealmChangeListener{
    private static final int TYPE_BANNER = 0;
    /**
     * header is a title to display date
     */
    private static final int TYPE_ITEM = 2;
    /**
     * footer is to show load more hint
     */
    private static final int TYPE_FOOTER = 3;
    private Realm mRealm;
    private OnListFragmentInteract mListener;
    private List<ZhihuStory> zhihuStories;
    private List<ZhihuTop> zhihuTops;
    private ConvenientBanner<ZhihuTop> banner;

    public ZhihuListAdapter(OnListFragmentInteract listener, BaseActivity mActivity) {
        mRealm = mActivity.mRealm;
        mListener = listener;
        zhihuStories = DB.findAll(mRealm,ZhihuStory.class);
        zhihuTops = DB.findAll(mRealm,ZhihuTop.class);

        mRealm.addChangeListener(this);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_BANNER) {
            View view = inflater.inflate(R.layout.fragment_news_banner, parent, false);
            return new BannerViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        if(holder instanceof BannerViewHolder){
            final  BannerViewHolder itemHolder = (BannerViewHolder) holder;
            itemHolder.banner.setPages(new CBViewHolderCreator<BannerView>() {
                @Override
                public BannerView createHolder() {
                    return new BannerView();
                }
            },zhihuTops);
            banner = itemHolder.banner;

        }


    }

    @Override
    public int getItemCount() {
        return zhihuStories.size()+2;
    }


    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_BANNER;
        }else if(position == zhihuStories.size()+1){
            return TYPE_FOOTER;
        }else{
            return TYPE_ITEM;
        }
    }


    @Override
    public void onChange() {

    }


    public class BannerViewHolder extends  RecyclerView.ViewHolder{
        public final ConvenientBanner<ZhihuTop> banner;

        public BannerViewHolder(View view) {
            super(view);
            banner = (ConvenientBanner<ZhihuTop>) view.findViewById(R.id.convenientBanner);
        }
    }
}
