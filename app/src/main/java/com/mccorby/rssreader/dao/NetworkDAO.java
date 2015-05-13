package com.mccorby.rssreader.dao;

import android.content.Context;

import com.mccorby.rssreader.api.RetrofitApiCaller;
import com.mccorby.rssreader.model.RssFeed;

import java.util.List;

/**
 * This class is an implementation of the DAO that takes the data from a remote server.
 * It delegates the call to the proper ApiCaller object. This can be injected depending on which
 * class use. In this case, we are just using the RetrofitApiCaller we built. If another library
 * is to be used, separation of concerns has been done to limit the impact of the change.
 *
 * Created by JAC on 13/05/2015.
 */
public class NetworkDAO implements FeedDAO {

    @Override
    public List<RssFeed> getRssFeeds(Context context) {
        return RetrofitApiCaller.getInstance(context).getFeeds();
    }
}
