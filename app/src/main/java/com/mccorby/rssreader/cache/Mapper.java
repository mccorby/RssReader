package com.mccorby.rssreader.cache;

import android.database.Cursor;

import com.mccorby.rssreader.model.FeedMapper;
import com.mccorby.rssreader.model.RssFeed;

import java.util.Date;

/**
 * Created by JAC on 14/05/2015.
 */
public class Mapper implements FeedMapper {

    @Override
    public RssFeed getRssFeed(Object item) {
        if (item instanceof Cursor) {
            Cursor cursor = (Cursor) item;
            RssFeed feed = new RssFeed();
            feed.setImageUrl(cursor.getString(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_IMAGE_URL)));
            feed.setGuid(cursor.getString(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_GUID)));
            feed.setTitle(cursor.getString(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_TITLE)));
            feed.setDescription(cursor.getString(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_DESCRIPTION)));
            feed.setLink(cursor.getString(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_LINK)));
            feed.setPubDate(new Date(cursor.getLong(cursor.getColumnIndex(CustomSQLiteHelper.COLUMN_TITLE))));

            return feed;
        }
        return null;
    }
}
