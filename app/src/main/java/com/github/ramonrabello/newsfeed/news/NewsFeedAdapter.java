package com.github.ramonrabello.newsfeed.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.ramonrabello.newsfeed.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for news feed.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.FeedItemViewHolder> {

    private List<FeedItem> feedItems;

    public NewsFeedAdapter() {
        feedItems = new ArrayList<>();
    }

    @Override
    public NewsFeedAdapter.FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item_view_holder, parent, false);
        return new FeedItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsFeedAdapter.FeedItemViewHolder holder, int position) {
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
            this. feedItems.addAll(feedItems);
            notifyItemRangeChanged(feedItems.size() + 1, feedItems.size());
        }
    }

    /**
     * View holder for feed items.
     */
    class FeedItemViewHolder extends BaseViewHolder<FeedItem> {

        @BindView(R.id.feed_item_title)
        TextView feedItemTitle;

        @BindView(R.id.feed_item_updated)
        TextView feedItemUpdated;

        @BindView(R.id.feed_item_thumb_image)
        ImageView feedItemThumbImage;


        FeedItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(FeedItem feedItem) {
            feedItemTitle.setText(feedItem.getTitle());
            feedItemUpdated.setText(String.valueOf(feedItem.getUpdated()));

            if (feedItem.withThumb()){
                Glide.with(getContext()).load(feedItem.getThumb()).into(feedItemThumbImage);
            } else {
                feedItemThumbImage.setVisibility(View.GONE);
            }
        }
    }
}
