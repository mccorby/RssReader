package com.mccorby.rssreader.dao;

import com.mccorby.rssreader.model.RssFeed;

import java.util.List;

/**
 * This class is an implementation of the DAO that takes the data from a remote server.
 *
 * Created by JAC on 13/05/2015.
 */
public class NetworkDAO implements FeedDAO {

    @Override
    public List<RssFeed> getRssFeeds() {
        return null;
    }
}
