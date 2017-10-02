package com.github.ramonrabello.newsfeed.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.detail.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapter for news feed.
 */
class NewsFeedAdapter extends RecyclerView.Adapter<FeedItemViewHolder> implements FeedItemViewHolder.OnFeedItemClickListener {

    private List<FeedItem> feedItems;
    private Context context;

    NewsFeedAdapter() {
        feedItems = new ArrayList<>();
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.feed_item_view_holder, parent, false);
        FeedItemViewHolder viewHolder = new FeedItemViewHolder(itemView);
        viewHolder.setOnFeedItemClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {
        if (!feedItems.isEmpty()){
            holder.bind(feedItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    void addItems(List<FeedItem> feedItems){
        if (!this.feedItems.containsAll(feedItems)){
            this.feedItems.addAll(feedItems);
            notifyItemRangeInserted(this.feedItems.size() + 1, feedItems.size());
        }
    }

    @Override
    public void onFeedItemClick(int position) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        FeedItem feedItem = feedItems.get(position);
        intent.putExtra(NewsDetailActivity.EXTRA_FEED_ITEM, feedItem);
        context.startActivity(intent);
    }
}
