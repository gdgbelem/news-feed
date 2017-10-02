package com.github.ramonrabello.newsfeed.news;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.TextUtils;

import butterknife.BindView;

/**
 * View holder for feed items.
 */
public class FeedItemViewHolder extends BaseViewHolder<FeedItem> implements View.OnClickListener {

    @BindView(R.id.feed_item_title)
    TextView feedItemTitle;

    @BindView(R.id.feed_item_time)
    TextView feedItemUpdated;

    @BindView(R.id.feed_item_thumb_image)
    ImageView feedItemThumbImage;

    private OnFeedItemClickListener onFeedItemClickListener;
    private UpdatedTimeFormatter updatedTimeFormatter = new UpdatedTimeFormatter();

    FeedItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        TextUtils.asRegular(getAssets(), feedItemTitle);
        TextUtils.asRegular(getAssets(), feedItemUpdated);
    }

    @Override
    public void bind(final FeedItem feedItem) {
        itemView.setTag(feedItem);
        feedItemTitle.setText(feedItem.getTitle());
        feedItemUpdated.setText(updatedTimeFormatter.format(feedItem.getUpdated()));

        if (feedItem.withThumb()) {
            if (!feedItemThumbImage.isShown()) {
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

    @Override
    public void onClick(View view) {
        if (onFeedItemClickListener != null) {
            onFeedItemClickListener.onFeedItemClick(getAdapterPosition());
        }
    }

    public void setOnFeedItemClickListener(OnFeedItemClickListener onFeedItemClickListener) {
        this.onFeedItemClickListener = onFeedItemClickListener;
    }

    interface OnFeedItemClickListener {
        void onFeedItemClick(int position);
    }
}