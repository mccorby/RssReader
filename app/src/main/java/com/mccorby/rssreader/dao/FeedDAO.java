package com.mccorby.rssreader.dao;

import android.content.Context;

import com.mccorby.rssreader.model.RssFeed;

import java.util.List;

/**
 * Contract that data providers must implement.
 *
 * Created by JAC on 13/05/2015.
 */
public interface FeedDAO {

    /**
     * Get a list of Rss Feeds
     * @return a list of RssFeed objects
     */
    List<RssFeed> getRssFeeds(Context context);

    /**
     * Add a list of feeds to the underlying persistence system.
     * This can be memory, a database, a file.
     * @param feedList
     */
    void addFeeds(List<RssFeed> feedList);

    /**
     * Open the DAO if necessary.
     */
    void open();

    /**
     * Close the DAO if necessary.
     */
    void close();
}
