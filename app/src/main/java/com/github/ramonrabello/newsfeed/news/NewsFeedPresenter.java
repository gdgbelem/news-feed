package com.github.ramonrabello.newsfeed.news;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.repository.remote.Api;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Presenter implementation for News Feed Contract.
 */
public class NewsFeedPresenter implements NewsContract.Presenter {

    private NewsContract.View view;

    public NewsFeedPresenter(NewsContract.View view) {
        this.view = view;
    }

    @Override
    public void loadNews() {
        view.showProgress();
        Api.get().feed().loadNewsFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsFeed>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgress();
                        view.notifyLoadingError(R.string.newsfeed_loading_error);
                    }

                    @Override
                    public void onNext(NewsFeed newsFeed) {
                        view.hideProgress();
                        view.showNewsFeed(newsFeed);
                    }
                });
    }

//    @Override
//    public void onShareUrlClick(String shareUrl) {
//        Uri uri = Uri.parse(shareUrl);
//        Intent intent = new Intent(Intent.ACTION_SEND, uri);
//        Intent.createChooser(intent, "Compartilhar");
//    }
}
