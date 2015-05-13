package com.mccorby.rssreader.dao;

import com.mccorby.rssreader.model.RssFeed;

import java.util.List;

/**
 * This class is an implementation of the DAO that takes the data from local storage.
 * CacheDAO delegates its methods into a content provider.
 *
 * Created by JAC on 13/05/2015.
 */
public class CacheDAO implements FeedDAO {

    @Override
    public List<RssFeed> getRssFeeds() {
        return null;
    }
}
