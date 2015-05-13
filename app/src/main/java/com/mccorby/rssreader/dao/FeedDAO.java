package com.mccorby.rssreader.dao;

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
    List<RssFeed> getRssFeeds();
}
