package com.github.ramonrabello.newsfeed.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.ramonrabello.newsfeed.BuildConfig;
import com.github.ramonrabello.newsfeed.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to display news feed.
 */
public class NewsFeedFragment extends Fragment implements NewsContract.View {

    @BindView(R.id.loading_progress)
    ProgressBar loadingProgress;

    @BindView(R.id.news_recycler_view)
    UltimateRecyclerView newsRecyclerView;

    @BindView(R.id.ad_view)
    AdView adView;

    private NewsFeedAdapter newsFeedAdapter;
    private NewsFeedPresenter newsFeedPresenter;

    public static NewsFeedFragment newInstance() {
      return new NewsFeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ButterKnife.bind(this, view);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsRecyclerView.addItemDecoration(new LineDividerItemDecoration(getActivity()));
        newsFeedAdapter = new NewsFeedAdapter();
        newsFeedPresenter = new NewsFeedPresenter(this);
        newsRecyclerView.setAdapter(newsFeedAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (BuildConfig.DEBUG) {
            AdRequest.Builder adRequestBuilder = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            adView.loadAd(adRequestBuilder.build());
        }
        newsFeedPresenter.loadNews();
    }

    @Override
    public void showProgress() {
        loadingProgress.setVisibility(View.VISIBLE);
        newsRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        loadingProgress.setVisibility(View.GONE);
        newsRecyclerView.setVisibility(View.VISIBLE);
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
