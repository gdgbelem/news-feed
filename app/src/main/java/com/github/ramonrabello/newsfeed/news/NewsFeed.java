package com.github.ramonrabello.newsfeed.news;

import java.util.List;

/**
 * Model representation for news feed JSON.
 */
public class NewsFeed {

    private List<FeedItem> feed;

    public List<FeedItem> getFeed() {
        return feed;
    }

    public void setFeed(List<FeedItem> feed) {
        this.feed = feed;
    }
}
