package com.github.ramonrabello.newsfeed.news;

import com.google.gson.annotations.SerializedName;

/**
 * Model that represents a feed item in news feed.
 */
class FeedItem {
    private String type;
    private String title;
    private String thumb;
    private int updated;

    @SerializedName("share-url")
    private String shareUrl;

    @SerializedName("webview-url")
    private String webviewUrl;



    public boolean withThumb(){
        return thumb != null;
    }

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

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
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
        result = 31 * result + updated;
        result = 31 * result + (shareUrl != null ? shareUrl.hashCode() : 0);
        result = 31 * result + (webviewUrl != null ? webviewUrl.hashCode() : 0);
        return result;
    }
}
