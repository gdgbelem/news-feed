package com.github.ramonrabello.newsfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.ramonrabello.newsfeed.common.TextUtils;
import com.github.ramonrabello.newsfeed.news.NewsFeedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        TextUtils.spanToolbarTitle(this, toolbar.getTitle(), 25, getSupportActionBar());

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, NewsFeedFragment.newInstance()).addToBackStack(null).commit();
        }
    }
}
