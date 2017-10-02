package com.github.ramonrabello.newsfeed.detail;

import android.net.Uri;

import com.github.ramonrabello.newsfeed.news.FeedItem;

import java.util.Locale;

/**
 * MVP Presenter implementation for {@link NewsDetailContract.Presenter}.
 */
class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.View view;

    NewsDetailPresenter(NewsDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void shareUrl(FeedItem feedItem) {
        ShareTextFormatter shareText = new ShareTextFormatter();
        view.openIntentChooserToShareUrl(shareText.format(feedItem));
    }
}
