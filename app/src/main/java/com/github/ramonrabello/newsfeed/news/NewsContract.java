package com.github.ramonrabello.newsfeed.news;

import android.content.Intent;
import android.support.annotation.StringRes;

/**
 * MVP contract for NewsFeed.
 */
interface NewsContract {

    /**
     * Presenter for news contract.
     */
    interface Presenter {
        void loadNews();
    }

    /**
     * View for news contract.
     */
    interface View {
        void showProgress();
        void hideProgress();
        void showNewsFeed(NewsFeed newsFeed);
        void notifyLoadingError(@StringRes int messageResId);
    }
}
