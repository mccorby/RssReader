package com.mccorby.rssreader.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JAC on 14/05/2015.
 */
public class CustomSQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_FEEDS = "feeds";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_LINK = "link";
    public static final String COLUMN_GUID = "guid";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE_URL = "image_url";
    public static final String COLUMN_DATE = "feed_date";


    private static final String DATABASE_NAME = "feeds.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_FEEDS + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_TITLE + " TEXT, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_LINK + " TEXT, "
            + COLUMN_GUID + " TEXT NOT NULL UNIQUE, " // We don't want repeated guids!
            + COLUMN_IMAGE_URL + " TEXT, "
            + COLUMN_DATE + " INTEGER"
            + ");";

    public CustomSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FEEDS);
        onCreate(db);
    }
}
