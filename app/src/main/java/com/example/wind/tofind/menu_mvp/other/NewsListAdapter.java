package com.example.wind.tofind.menu_mvp.other;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wind.tofind.R;
import com.example.wind.tofind.menu_mvp.model.FreshPost;
import com.example.wind.tofind.net.DB;
import com.example.wind.tofind.ui.BaseActivity;
import com.example.wind.tofind.utils.Imager;

import java.util.List;
import java.util.zip.Inflater;

import io.realm.Realm;

/**
 * Fresh news' recyclerView adapter
 */
public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Realm realm;
    private List<FreshPost> freshPosts;
    private OnListFragmentInteract mListener;

    public NewsListAdapter(OnListFragmentInteract listener, BaseActivity activity) {
        mListener = listener;
        realm = activity.mRealm;
        freshPosts = DB.findAllDateSorted(realm,FreshPost.class);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_fresh_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.freshPost = freshPosts.get(position);
        String imgUrl = viewHolder.freshPost.getCustom_fields().getThumb_c().get(0).getVal();

        viewHolder.mTitle.setText(viewHolder.freshPost.getTitle());
        //viewHolder.mTitle.setTextColor(ZhihuListAdapter.textDark);
        Imager.load(viewHolder.itemView.getContext(), imgUrl, viewHolder.mImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(viewHolder);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return freshPosts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public final ImageView mImage;
        public final TextView mTitle;
        public final View mItem;
        public FreshPost freshPost;

        public ViewHolder(View view) {
            super(view);
            mImage = (ImageView) view.findViewById(R.id.story_img);
            mTitle = (TextView) view.findViewById(R.id.news_title);
            mItem = view.findViewById(R.id.news_item);
        }
    }
}
