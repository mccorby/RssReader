package com.mccorby.rssreader.api.model;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;

import com.mccorby.rssreader.model.FeedMapper;
import com.mccorby.rssreader.model.RssFeed;

/**
 * Maps the Item model to the domain model RssFeed.
 *
 * Created by JAC on 13/05/2015.
 */
public class Mapper implements FeedMapper {

    private static final String TAG = Mapper.class.getSimpleName();

    private String imgUrl;

    private Html.ImageGetter mImageGetter = new Html.ImageGetter() {
        @Override
        public Drawable getDrawable(String source) {
            Log.d(TAG, "Obtain source => " + source);
            if (TextUtils.isEmpty(imgUrl)) {
                imgUrl = source;
            }
            return null;
        }
    };

    @Override
    public RssFeed getRssFeed(Object item) {
        if (item instanceof Channel.Item) {
            Channel.Item channelItem = (Channel.Item) item;
            RssFeed feed = new RssFeed();
            feed.setDescription(channelItem.description);
            feed.setGuid(channelItem.guid);
            feed.setLink(channelItem.link);
            feed.setTitle(channelItem.title);
            feed.setImageUrl(obtainFirstImg(feed));
            return feed;
        }
        return null;
    }

    /**
     * Retrieves the first img tag url in the description of the feed (if any)
     * @param feed the feed to process
     * @return the url of the image
     */
    private String obtainFirstImg(RssFeed feed) {
        Html.fromHtml(feed.getDescription(), mImageGetter, null);
        return imgUrl;
    }

    /**
     * A mapper can be reused. This method resets any attribute that requires it.
     */
    public void reset() {
        this.imgUrl = null;
    }
}
