package com.mccorby.rssreader.model;

import java.util.Date;

/**
 * This is a POJO holding the basic attributes of an RSS Feed.
 * This could be refactored to remove such dependencies.
 *
 * Created by JAC on 13/05/2015.
 */

public class RssFeed {

    private String mTitle;
    private String mLink;
    private String mGuid;
    private Date mPubDate;
    private String mDescription;

    @Override
    public String toString() {
        return "RssFeed{" +
                "mTitle='" + mTitle + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mGuid='" + mGuid + '\'' +
                '}';
    }

    /*==============================
    GETTERS AND SETTERS
     */

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getGuid() {
        return mGuid;
    }

    public void setGuid(String guid) {
        mGuid = guid;
    }

    public Date getPubDate() {
        return mPubDate;
    }

    public void setPubDate(Date pubDate) {
        mPubDate = pubDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
