package com.mccorby.rssreader.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mccorby.rssreader.R;
import com.mccorby.rssreader.model.RssFeed;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * The view adapter for the RSS Feed list.
 * It uses the new RecyclerView.Adapter that implements the ViewHolder pattern.
 *
 * Created by JAC on 13/05/2015.
 */
public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> {


    private final FeedListItemListener mListener;
    private List<RssFeed> mFeedList;
    // We need a context to work with Picasso.
    // TODO Refactor by injecting the context
    private final Context mContext;

    public interface FeedListItemListener {
        void onFeedItemSelected(RssFeed item);
    }

    public FeedListAdapter(Context context, List<RssFeed> feedList, FeedListItemListener listener) {
        this.mContext = context;
        this.mFeedList = feedList;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rss_feed, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RssFeed feed = mFeedList.get(i);
        viewHolder.mTitleTv.setText(feed.getTitle());
        viewHolder.mDescTv.setText(Html.fromHtml(feed.getDescription()));
        if (!TextUtils.isEmpty(feed.getImageUrl())) {
            Picasso.with(mContext).load(feed.getImageUrl()).into(viewHolder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mFeedList != null ? mFeedList.size() : 0;
    }

    /**
     * The view holder for each row in the adapter.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleTv;
        TextView mDescTv;
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.item_rss_feed_title_tv);
            mDescTv = (TextView) itemView.findViewById(R.id.item_rss_feed_desc_tv);
            mImageView = (ImageView) itemView.findViewById(R.id.item_rss_feed_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFeedItemSelected(mFeedList.get(getAdapterPosition()));
                }
            });
        }
    }
}
