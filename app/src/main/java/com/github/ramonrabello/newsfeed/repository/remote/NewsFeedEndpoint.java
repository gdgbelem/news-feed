package com.github.ramonrabello.newsfeed.repository.remote;

import com.github.ramonrabello.newsfeed.news.NewsFeed;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Retrofit's endpoint interface.
 */
public interface NewsFeedEndpoint {

    @GET("/c/api/v1/list/news/?app=uol-placar-futebol&version=2")
    Observable<NewsFeed> loadNewsFeed();
}
