package com.mccorby.rssreader.model;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.Date;

/**
 * This is a POJO holding the basic attributes of an RSS Feed.
 * It shows some dependencies on Gson and the Parcelable interface.
 * This could be refactored to remove such dependencies.
 *
 * Created by JAC on 13/05/2015.
 */
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2005/Atom", prefix = "atom")
})
@Root(name="item", strict = false)
public class RssFeed {

    @Element(name = "title")
    @SerializedName("title")
    private String mTitle;

    @Element(name = "link")
    @SerializedName("link")
    private String mLink;

    @Element(name = "guid")
    @SerializedName("guid")
    private String mGuid;

    @Element(name = "pubDate")
    @SerializedName("pubDate")
    private Date mPubDate;

    @Element(name = "description")
    @SerializedName("description")
    private String mDescription;

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
