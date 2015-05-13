package com.mccorby.rssreader.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mccorby.rssreader.Constants;
import com.mccorby.rssreader.R;
import com.mccorby.rssreader.api.model.Channel;
import com.mccorby.rssreader.api.model.Mapper;
import com.mccorby.rssreader.model.RssFeedList;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * This class encapsulates the actual calls to the API.
 * It depends on Retrofit RestAdapter.
 * Only one instance of this class exists in the system so it'd modelled as a Singleton.
 *
 * Created by JAC on 13/05/2015.
 */
public class RetrofitApiCaller {

    /**
     * The RestAdapter provided by Retrofit.
     */
    private RestAdapter mRestAdapter;

    private static RetrofitApiCaller mInstance;

    /**
     * Construct the sole instance of this class.
     * The converter is by default an XML converter.
     * TODO Feature "Change datasource" will provide a new model that can differentiate between json and XML.
     * @param context
     */
    private RetrofitApiCaller(Context context) {
        String endPoint = getEndpoint(context);
        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endPoint)
                .setConverter(new SimpleXMLConverter())
                .build();
    }

    /**
     * The method to obtain the singleton.
     * TODO Note that it does not implement double locking.
     * @param context
     * @return
     */
    public static RetrofitApiCaller getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RetrofitApiCaller(context);
        }
        return mInstance;
    }

    /**
     * The endpoint is stored in the shared preferences of the app
     * @param context the context used in this operation
     * @return the string representation of the endpoint
     */
    private String getEndpoint(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.PREFS_RSS_SOURCE_URL, context.getString(R.string.default_source_url));
    }

    public RssFeedList getFeeds() {
        ApiCallerService service = mRestAdapter.create(ApiCallerService.class);
        List<Channel.Item> itemList = service.getFeeds().getChannel().itemList;
        RssFeedList list = new RssFeedList(itemList.size());
        for (Channel.Item item : itemList) {
            list.add(Mapper.getRssFeed(item));
        }
        return list;
    }
}
