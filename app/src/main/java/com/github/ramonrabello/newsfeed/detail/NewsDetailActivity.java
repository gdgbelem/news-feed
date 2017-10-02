package com.github.ramonrabello.newsfeed.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.BaseActivity;
import com.github.ramonrabello.newsfeed.news.FeedItem;

/**
 * Activity that displays news details.
 */
public class NewsDetailActivity extends BaseActivity {

    public static final String EXTRA_FEED_ITEM = "com.github.ramonrabello.newsfeed.feed.item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (getToolbar() != null){
            getToolbar().setNavigationIcon(R.drawable.ic_arrow_back_white_24px);
        }

        if (savedInstanceState == null){
            FeedItem feedItem = getIntent().getParcelableExtra(EXTRA_FEED_ITEM);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, NewsDetailFragment.newInstance(feedItem)).addToBackStack(null).commit();
        }
    }
}
