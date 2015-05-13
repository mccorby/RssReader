package com.mccorby.rssreader.api;

import com.mccorby.rssreader.api.model.RSS;
import com.mccorby.rssreader.model.RSS;
import com.mccorby.rssreader.model.RssFeedList;

import retrofit.http.GET;

/**
 * The interface providing the calls to the API using Retrofit.
 *
 * Created by JAC on 13/05/2015.
 */
public interface ApiCallerService {

    @GET("/")
    RSS getFeeds();
}
