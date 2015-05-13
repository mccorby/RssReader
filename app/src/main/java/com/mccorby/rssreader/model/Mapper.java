package com.mccorby.rssreader.model;

/**
 * Created by JAC on 13/05/2015.
 */
public class Mapper {

    public static RssFeed getRssFeed(Channel.Item item) {
        RssFeed feed = new RssFeed();
        feed.setDescription(item.description);
        feed.setGuid(item.guid);
        feed.setLink(item.link);
        feed.setTitle(item.title);

        return feed;
    }
}