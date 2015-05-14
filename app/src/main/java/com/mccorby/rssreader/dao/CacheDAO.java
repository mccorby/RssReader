package com.mccorby.rssreader.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mccorby.rssreader.cache.CustomSQLiteHelper;
import com.mccorby.rssreader.cache.Mapper;
import com.mccorby.rssreader.model.RssFeed;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of the DAO that takes the data from local storage.
 * CacheDAO delegates its methods into a content provider.
 *
 * Created by JAC on 13/05/2015.
 */
public class CacheDAO implements FeedDAO {

    private static final String TAG = CacheDAO.class.getSimpleName();

    private String[] allColumns = {
            CustomSQLiteHelper.COLUMN_ID,
            CustomSQLiteHelper.COLUMN_DATE,
            CustomSQLiteHelper.COLUMN_DESCRIPTION,
            CustomSQLiteHelper.COLUMN_GUID,
            CustomSQLiteHelper.COLUMN_IMAGE_URL,
            CustomSQLiteHelper.COLUMN_LINK,
            CustomSQLiteHelper.COLUMN_TITLE,
    };

    // Database fields
    private SQLiteDatabase database;
    private CustomSQLiteHelper dbHelper;

    public CacheDAO(Context context) {
        dbHelper = new CustomSQLiteHelper(context);
    }

    @Override
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        dbHelper.close();
    }

    @Override
    public void addFeeds(List<RssFeed> feedList) {
        // TODO Bulk insert

        for (RssFeed feed : feedList) {
            addFeed(feed);
        }
    }

    /**
     * Insert a single feed in the database.
     * @param feed the feed to be inserted
     */
    private void addFeed(RssFeed feed) {
        ContentValues values = new ContentValues();
        if (feed.getPubDate() != null) {
            values.put(CustomSQLiteHelper.COLUMN_DATE, feed.getPubDate().getTime());
        }
        values.put(CustomSQLiteHelper.COLUMN_DESCRIPTION, feed.getDescription());
        values.put(CustomSQLiteHelper.COLUMN_GUID, feed.getGuid());
        values.put(CustomSQLiteHelper.COLUMN_IMAGE_URL, feed.getImageUrl());
        values.put(CustomSQLiteHelper.COLUMN_LINK, feed.getLink());
        values.put(CustomSQLiteHelper.COLUMN_TITLE, feed.getTitle());

        long insertId = 0;
        try {
            insertId = database.insert(
                    CustomSQLiteHelper.TABLE_FEEDS,
                    null,
                    values);
        }catch (Exception constraintException){
            // TODO Some other mechanism to avoid duplicates could be set in place
        }
        if (insertId > 0) {
            Log.d(TAG, "Insert was good");
        } else {
            Log.e(TAG, "Error insert feed " + feed);
        }

    }

    @Override
    public List<RssFeed> getRssFeeds(Context context) {
        List<RssFeed> result = new ArrayList<>();

        Cursor cursor = database.query(CustomSQLiteHelper.TABLE_FEEDS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        Mapper mapper = new Mapper();
        while (!cursor.isAfterLast()) {
            RssFeed feed = mapper.getRssFeed(cursor);
            result.add(feed);
            cursor.moveToNext();
        }
        // Close the cursor!
        cursor.close();
        return result;
    }
}
