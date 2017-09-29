package com.github.ramonrabello.newsfeed.news;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.TextUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
            this.feedItems.addAll(feedItems);
            notifyItemRangeInserted(this.feedItems.size() + 1, feedItems.size());
        }
    }

    /**
     * View holder for feed items.
     */
    class FeedItemViewHolder extends BaseViewHolder<FeedItem> {

        @BindView(R.id.feed_item_title)
        TextView feedItemTitle;

        @BindView(R.id.feed_item_time)
        TextView feedItemUpdated;

        @BindView(R.id.feed_item_thumb_image)
        ImageView feedItemThumbImage;

        FeedItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            TextUtils.asRegular(getAssets(), feedItemTitle);
            TextUtils.asLight(getAssets(), feedItemUpdated);
        }

        @Override
        public void bind(FeedItem feedItem) {
            itemView.setTag(feedItem);
            feedItemTitle.setText(feedItem.getTitle());
            feedItemUpdated.setText(new UpdatedTimeFormatter().format(feedItem.getUpdated()));

            if (feedItem.withThumb()){
                if (!feedItemThumbImage.isShown()){
                    feedItemThumbImage.setVisibility(View.VISIBLE);
                }
                Glide.with(getContext()).load(feedItem.getThumb()).
                        apply(RequestOptions.placeholderOf(new ColorDrawable(ContextCompat.getColor(getContext(), R.color.grayLineDivider))))
                        .apply(RequestOptions.centerCropTransform())
                        .into(feedItemThumbImage);
            } else {
                feedItemThumbImage.setVisibility(View.GONE);
            }
        }
    }
}
