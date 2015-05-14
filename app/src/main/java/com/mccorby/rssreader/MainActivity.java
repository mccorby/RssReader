package com.mccorby.rssreader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mccorby.rssreader.fragment.RssFeedDetailFragment;
import com.mccorby.rssreader.fragment.RssFeedListFragment;
import com.mccorby.rssreader.model.RssFeed;


public class MainActivity extends Activity implements RssFeedListFragment.FeedListCallback{

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new RssFeedListFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFeedSelected(RssFeed feed) {
        Log.d(TAG, "onFeedSelected " + feed.toString());
        RssFeedDetailFragment detailFragment = new RssFeedDetailFragment();

        // Add the feed as an argument.
        Bundle args = new Bundle();
        args.putParcelable(Constants.ARG_FEED, feed);
        detailFragment.setArguments(args);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit();

    }
}
