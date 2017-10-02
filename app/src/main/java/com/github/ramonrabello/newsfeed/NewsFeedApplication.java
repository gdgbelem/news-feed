package com.github.ramonrabello.newsfeed;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 * Base application class.
 */
public class NewsFeedApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }
}
