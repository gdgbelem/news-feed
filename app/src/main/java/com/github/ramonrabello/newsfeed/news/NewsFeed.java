package com.github.ramonrabello.newsfeed.news;

import java.util.ArrayList;
import java.util.List;

/**
 * Model representation for news feed JSON.
 */
public class NewsFeed {

    private List<FeedItem> feed = new ArrayList<>();

    public List<FeedItem> getFeed() {
        return feed;
    }

    public void setFeed(List<FeedItem> feed) {
        this.feed = feed;
    }

    public void addItem(FeedItem feedItem){
        feed.add(feedItem);
    }

    public void addItems(List<FeedItem> feedItems){
        feed.addAll(feedItems);
    }
}
