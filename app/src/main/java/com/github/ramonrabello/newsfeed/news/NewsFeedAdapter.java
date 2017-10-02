package com.github.ramonrabello.newsfeed.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.detail.NewsDetailActivity;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapter for news feed.
 */
class NewsFeedAdapter extends UltimateViewAdapter implements FeedItemViewHolder.OnFeedItemClickListener {

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedItemViewHolder viewHolder = (FeedItemViewHolder) holder;
        if (position < getItemCount() && (customHeaderView != null ? position <= feedItems.size() : position < feedItems.size()) && (customHeaderView != null ? position > 0 : true)) {
            viewHolder.bind(feedItems.get(position));
        }
    }

    @Override
    public RecyclerView.ViewHolder newFooterHolder(View view) {
        return new UltimateRecyclerviewViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder newHeaderHolder(View view) {
        return new UltimateRecyclerviewViewHolder(view);
    }

    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item_view_holder, parent, false);
        return new FeedItemViewHolder(v);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stick_header_item, parent, false);
        return new StickyHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        StickyHeaderViewHolder viewHolder = (StickyHeaderViewHolder) holder;
        FeedItem feedItem = feedItems.get(position);
        viewHolder.bind(feedItem.getUpdated());
    }

    @Override
    public int getAdapterItemCount() {
        return feedItems.size();
    }

    @Override
    public long generateHeaderId(int position) {
        if (feedItems.size() > 0) {
            return getItem(position).hashCode();
        } else return -1;
    }

    public FeedItem getItem(int position) {
        if (customHeaderView != null)
            position--;
        if (position >= 0 && position < feedItems.size()) {
            return feedItems.get(position);
        } else return null;
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
