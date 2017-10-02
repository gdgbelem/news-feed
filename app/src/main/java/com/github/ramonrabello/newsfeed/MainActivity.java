package com.github.ramonrabello.newsfeed;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.ramonrabello.newsfeed.common.BaseActivity;
import com.github.ramonrabello.newsfeed.news.NewsFeedFragment;
import com.google.android.gms.ads.AdRequest;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, NewsFeedFragment.newInstance()).addToBackStack(null).commit();
        }
    }
}
