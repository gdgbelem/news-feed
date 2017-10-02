package com.github.ramonrabello.newsfeed.news;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Model that represents a feed item in news feed.
 */
public class FeedItem implements Parcelable{
    private String type;
    private String title;
    private String thumb;
    private long updated;

    @SerializedName("share-url")
    private String shareUrl;

    @SerializedName("webview-url")
    private String webviewUrl;

    protected FeedItem(Parcel in) {
        type = in.readString();
        title = in.readString();
        thumb = in.readString();
        updated = in.readLong();
        shareUrl = in.readString();
        webviewUrl = in.readString();
    }

    public static final Creator<FeedItem> CREATOR = new Creator<FeedItem>() {
        @Override
        public FeedItem createFromParcel(Parcel in) {
            return new FeedItem(in);
        }

        @Override
        public FeedItem[] newArray(int size) {
            return new FeedItem[size];
        }
    };

    public boolean withThumb(){
        return thumb != null;
    }

    public boolean withShareUrl() { return shareUrl != null; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getWebviewUrl() {
        return webviewUrl;
    }

    public void setWebviewUrl(String webviewUrl) {
        this.webviewUrl = webviewUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(title);
        parcel.writeString(thumb);
        parcel.writeLong(updated);
        parcel.writeString(shareUrl);
        parcel.writeString(webviewUrl);
    }
}
