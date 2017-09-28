package com.github.ramonrabello.newsfeed.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by ramonrabello on 28/09/17.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.FeedItemViewHolder> {

    private List<FeedItem> feedItems;

    public NewsFeedAdapter() {
        feedItems = new ArrayList<>();
    }

    @Override
    public NewsFeedAdapter.FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(NewsFeedAdapter.FeedItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    void addItems(List<FeedItem> feedItems){
        if (!this.feedItems.containsAll(feedItems)){
            this. feedItems.addAll(feedItems);
            notifyItemRangeChanged(feedItems.size() + 1, feedItems.size());
        }
    }

    class FeedItemViewHolder extends BaseViewHolder<FeedItem> {

        public FeedItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(FeedItem feedItem) {

        }
    }
}
