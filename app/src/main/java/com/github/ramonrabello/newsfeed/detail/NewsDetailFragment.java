package com.github.ramonrabello.newsfeed.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.news.FeedItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment to display news feed.
 */
public class NewsDetailFragment extends Fragment implements NewsDetailContract.View {

    @BindView(R.id.web_view)
    WebView webView;

    @BindView(R.id.loading_progress)
    ProgressBar loadingProgress;

    private MenuItem shareMenuItem;
    private FeedItem feedItem;
    private static final String ARGS_FEED_ITEM = "args.feed.item";
    private NewsDetailContract.Presenter newsDetailPresenter;

    public static NewsDetailFragment newInstance(FeedItem feedItem) {
        Bundle args = new Bundle();
        args.putParcelable(ARGS_FEED_ITEM, feedItem);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ButterKnife.bind(this, view);
        configWebView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsDetailPresenter = new NewsDetailPresenter(this);
    }

    private void configWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    shareMenuItem.setVisible(true);
                    loadingProgress.setVisibility(View.GONE);
                } else {
                    loadingProgress.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        loadUrl();
    }

    private void loadUrl() {
        feedItem = getArguments().getParcelable(ARGS_FEED_ITEM);
        if (feedItem != null) {
            if (feedItem.withShareUrl()) {
                webView.loadUrl(feedItem.getShareUrl());
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.news_detail_menu, menu);
        shareMenuItem = menu.findItem(R.id.action_share);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                getActivity().finish();
                break;
            }
            case R.id.action_share:{
                newsDetailPresenter.shareUrl(feedItem);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openIntentChooserToShareUrl(String shareText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(intent, null));
    }
}
