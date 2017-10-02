package com.github.ramonrabello.newsfeed.common;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.ramonrabello.newsfeed.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Base activity with common features like views binding, toolbar customization, etc.
 */
public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (toolbar != null){
            TextUtils.spanToolbarTitle(this, toolbar.getTitle(), 14, getSupportActionBar());
        }
    }

    @Nullable
    protected Toolbar getToolbar(){
        return toolbar;
    }
}
