package com.mccorby.rssreader.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mccorby.rssreader.Constants;
import com.mccorby.rssreader.R;
import com.mccorby.rssreader.model.RssFeed;

/**
 * A simple {@link Fragment} subclass.
 */
public class RssFeedDetailFragment extends Fragment {

    /** The model used in this fragment. */
    private RssFeed mRssFeed;

    private TextView mTitleTv;
    private TextView mDescriptionTv;
    private ImageView mImage;
    private Button mActionBtn;

    public RssFeedDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRssFeed = getArguments().getParcelable(Constants.ARG_FEED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rss_feed_detail, container, false);
        mTitleTv = (TextView) rootView.findViewById(R.id.fragment_rss_feed_detail_title_tv);
        mDescriptionTv = (TextView) rootView.findViewById(R.id.fragment_rss_feed_detail_description_tv);
        mImage = (ImageView) rootView.findViewById(R.id.fragment_rss_feed_detail_image);
        mActionBtn = (Button) rootView.findViewById(R.id.fragment_rss_feed_detail_action_btn);

        mActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mRssFeed.getLink()));
                startActivity(intent);
            }
        });

        updateUI();

        return rootView;
    }

    public void setRssFeed(RssFeed feed) {
        this.mRssFeed = feed;
        updateUI();
    }

    private void updateUI() {
        if (mRssFeed != null) {
            mTitleTv.setText(mRssFeed.getTitle());
            mDescriptionTv.setText(Html.fromHtml(mRssFeed.getDescription()));
        }
    }
}
