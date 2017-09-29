package com.github.ramonrabello.newsfeed.news;

import com.google.gson.annotations.SerializedName;

/**
 * Model that represents a feed item in news feed.
 */
class FeedItem {
    private String type;
    private String title;
    private String thumb;
    private long updated;

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
}
