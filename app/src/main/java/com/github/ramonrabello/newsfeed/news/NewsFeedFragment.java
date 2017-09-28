package com.github.ramonrabello.newsfeed.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ramonrabello.newsfeed.R;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to display news feed.
 */
public class NewsFeedFragment extends Fragment implements NewsContract.View {

    @BindView(R.id.news_recycler_view)
    SuperRecyclerView newsRecyclerView;

    private NewsFeedAdapter newsFeedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ButterKnife.bind(this, view);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsFeedAdapter = new NewsFeedAdapter();
        newsRecyclerView.setAdapter(newsFeedAdapter);

        return view;
    }

    @Override
    public void showProgress() {
        newsRecyclerView.showProgress();
    }

    @Override
    public void hideProgress() {
        newsRecyclerView.hideProgress();
    }

    @Override
    public void showNewsFeed(NewsFeed newsFeed) {
        newsFeedAdapter.addItems(newsFeed.getFeed());
    }

    @Override
    public void notifyLoadingError(@StringRes int messageResId) {
        Snackbar.make(newsRecyclerView, messageResId, Snackbar.LENGTH_SHORT).show();
    }
}
