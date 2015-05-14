package com.mccorby.rssreader.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * This is a POJO holding the basic attributes of an RSS Feed.
 * This could be refactored to remove such dependencies.
 *
 * Created by JAC on 13/05/2015.
 */

public class RssFeed implements Parcelable{

    private String mTitle;
    private String mLink;
    private String mGuid;
    private Date mPubDate;
    private String mDescription;
    private String mImageUrl;

    public RssFeed() {

    }

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

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    /*=====================
     * The parcelable required members.
     */

    public static final Parcelable.Creator<RssFeed> CREATOR
            = new Parcelable.Creator<RssFeed>() {
        public RssFeed createFromParcel(Parcel in) {
            return new RssFeed(in);
        }

        public RssFeed[] newArray(int size) {
            return new RssFeed[size];
        }
    };

    private RssFeed(Parcel in) {
        mTitle = in.readString();
        mLink = in.readString();
        mGuid = in.readString();
        mPubDate = new Date(in.readLong());
        mDescription = in.readString();
        mImageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mLink);
        dest.writeString(mGuid);
        if (mPubDate != null) {
            dest.writeLong(mPubDate.getTime());
        } else {
            dest.writeLong(0);
        }
        dest.writeString(mDescription);
        dest.writeString(mImageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }}
