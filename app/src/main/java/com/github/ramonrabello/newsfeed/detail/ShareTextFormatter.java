package com.github.ramonrabello.newsfeed.detail;

import com.github.ramonrabello.newsfeed.common.Formatter;
import com.github.ramonrabello.newsfeed.news.FeedItem;

import java.util.Locale;

/**
 * {@link Formatter} for a text to be shared from a feed item.
 */
class ShareTextFormatter implements Formatter<FeedItem> {

    @Override
    public String format(FeedItem feedItem) {
        return feedItem.getTitle() +
                String.format(Locale.getDefault(),
                        ". Veja mais no News Feed. Acesse: %s",
                        feedItem.getShareUrl());
    }
}
