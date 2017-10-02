package com.github.ramonrabello.newsfeed.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Header view holder.
 */
class StickyHeaderViewHolder extends BaseViewHolder<Long> {

    @BindView(R.id.stick_text)
    TextView stickyText;

    private UpdatedDateFormatter updatedDateFormatter = new UpdatedDateFormatter();

    public StickyHeaderViewHolder(View itemView) {
        super(itemView);
        TextUtils.asLight(getAssets(), stickyText);
    }

    @Override
    public void bind(Long updatedDate) {
        stickyText.setText(updatedDateFormatter.format(updatedDate));
    }
}
