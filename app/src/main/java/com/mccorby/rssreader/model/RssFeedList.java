package com.mccorby.rssreader.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Required as per Jake Wharton notes on bug in Retrofit.
 * Created by JAC on 13/05/2015.
 */
public class RssFeedList extends ArrayList<RssFeed> {
    public RssFeedList(int capacity) {
        super(capacity);
    }
}
