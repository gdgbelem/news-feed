package com.github.ramonrabello.newsfeed.detail;

import android.net.Uri;

import com.github.ramonrabello.newsfeed.news.FeedItem;

/**
 * Contract for News Details.
 */
public interface NewsDetailContract {

    interface Presenter {
        void shareUrl(FeedItem feedItem);
    }

    interface View {
        void openIntentChooserToShareUrl(String shareText);
    }
}
