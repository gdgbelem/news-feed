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

    public FeedItem(Parcel in) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedItem feedItem = (FeedItem) o;

        if (updated != feedItem.updated) return false;
        if (type != null ? !type.equals(feedItem.type) : feedItem.type != null) return false;
        if (title != null ? !title.equals(feedItem.title) : feedItem.title != null) return false;
        if (thumb != null ? !thumb.equals(feedItem.thumb) : feedItem.thumb != null) return false;
        if (shareUrl != null ? !shareUrl.equals(feedItem.shareUrl) : feedItem.shareUrl != null)
            return false;
        return webviewUrl != null ? webviewUrl.equals(feedItem.webviewUrl) : feedItem.webviewUrl == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
        result = 31 * result + (int) (updated ^ (updated >>> 32));
        result = 31 * result + (shareUrl != null ? shareUrl.hashCode() : 0);
        result = 31 * result + (webviewUrl != null ? webviewUrl.hashCode() : 0);
        return result;
    }
}
