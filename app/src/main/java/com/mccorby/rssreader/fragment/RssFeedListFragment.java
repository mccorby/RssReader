package com.mccorby.rssreader.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mccorby.rssreader.R;
import com.mccorby.rssreader.loader.FeedListLoader;
import com.mccorby.rssreader.model.RssFeed;

import java.util.List;


/**
 * A fragment in charge of displaying a list of Rss Feeds.
 *
 * The fragment is responsible for calling the DAO and display the results.
 */
public class RssFeedListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<RssFeed>> {

    private static final String TAG = RssFeedListFragment.class.getSimpleName();
    private static final int FEED_LIST_LOADER = 0;

    /** A listener on events in the list, mainly the Activity that handles this fragment. */
    private FeedListCallback mListener;

    public interface FeedListCallback {
        void onFeedSelected(RssFeed feed);
    }

    public RssFeedListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(FEED_LIST_LOADER, null, this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FeedListCallback) {
            mListener = (FeedListCallback) activity;
        } else {
            throw new IllegalStateException("Activity must implement FeedListCallback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }



    @Override
    public Loader<List<RssFeed>> onCreateLoader(int id, Bundle args) {
        return new FeedListLoader(getActivity().getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<List<RssFeed>> loader, List<RssFeed> data) {
        for (RssFeed feed : data) {
            Log.d(TAG, feed.getTitle());
        }
    }

    @Override
    public void onLoaderReset(Loader<List<RssFeed>> loader) {

    }
}
