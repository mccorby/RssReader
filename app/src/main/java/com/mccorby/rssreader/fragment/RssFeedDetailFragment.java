package com.mccorby.rssreader.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mccorby.rssreader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RssFeedDetailFragment extends Fragment {


    public RssFeedDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rss_feed_detail, container, false);
    }


}
