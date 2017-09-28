package com.github.ramonrabello.newsfeed.repository.remote;

import com.github.ramonrabello.newsfeed.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Main entry-point for API REST endpoints calls, but in a fluent way.
 */
public class Api {
    public static final String BASE_URL = BuildConfig.API_BASE_URL;
    private static Retrofit retrofit;
    private static Api instance;

    private Api(){}

    public static Api get() {
        if (instance == null){
            instance = new Api();
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());

            // logging only when in debug environment
            if (BuildConfig.DEBUG){
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                retrofitBuilder.client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build());
            }
            retrofit = retrofitBuilder.build();
        }
        return instance;
    }

    public NewsFeedEndpoint feed(){
        return retrofit.create(NewsFeedEndpoint.class);
    }
}
