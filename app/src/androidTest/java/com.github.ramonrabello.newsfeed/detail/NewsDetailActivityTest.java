package com.github.ramonrabello.newsfeed.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.espresso.idlingresource.ElapsedTimeIdlingResource;
import com.github.ramonrabello.newsfeed.news.FeedItem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasType;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.github.ramonrabello.newsfeed.common.IntentMatchers.chooser;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * UI Tests for {@link NewsDetailActivity}.
 */
@RunWith(AndroidJUnit4.class)
public class NewsDetailActivityTest {

    @Rule
    public ActivityTestRule<NewsDetailActivity> intentsTestRule = new ActivityTestRule<>(NewsDetailActivity.class, true, false);

    private FeedItem feedItem;

    @Before
    public void setupContext(){
        Parcel parcel = Parcel.obtain();
        feedItem = new FeedItem(parcel);
        feedItem.setShareUrl("http://esporte.uol.com.br/futebol/campeonatos/brasileiro/serie-a/ultimas-noticias/2017/10/02/cavalieri-bate-milagres-no-flu-e-volta-com-atuacao-de-gala-apos-139-dias.htm");
        feedItem.setWebviewUrl("http://esporte.uol.com.br/futebol/campeonatos/brasileiro/serie-a/ultimas-noticias/2017/10/02/cavalieri-bate-milagres-no-flu-e-volta-com-atuacao-de-gala-apos-139-dias.htm?app=uol-placar-futebol&plataforma=iphone&template=v2");
        feedItem.setTitle("Cavalieri supera meta de milagres e volta com atuação de gala após 139 dias");
        parcel.recycle();
    }

    @Test
    public void whenActivityLaunched_shouldCheckIfWebViewIsVisible(){
        Context context = InstrumentationRegistry.getTargetContext();
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.EXTRA_FEED_ITEM, feedItem);
        intentsTestRule.launchActivity(intent);
        onView(withId(R.id.loading_progress)).check(matches(isDisplayed()));
        onView(withId(R.id.web_view)).check(matches(isDisplayed()));
    }

    @Test
    public void whenShareMenuItemClicked_shouldCheckIfIntentChooserIsAvailable(){
        Context context = InstrumentationRegistry.getTargetContext();
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.EXTRA_FEED_ITEM, feedItem);
        intentsTestRule.launchActivity(intent);

        long waitingTime = DateUtils.MINUTE_IN_MILLIS;

        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        // Now we wait
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        // click on menu share item
        onView(withId(R.id.action_share)).perform(click());

        // check if the chooser is being created and displayed
        // with the share text as extra
        intended(chooser(allOf(
                hasAction(Intent.ACTION_SEND),
                hasType(equalTo("text/plain")),
                hasExtra(Intent.EXTRA_TEXT, any(String.class)))));

        // clean up
        Espresso.unregisterIdlingResources(idlingResource);

    }

    @Test
    public void whenActivityLaunched_shouldCheckIfShareMenuItemIsInvisible(){
        Context context = InstrumentationRegistry.getTargetContext();
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.EXTRA_FEED_ITEM, feedItem);
        intentsTestRule.launchActivity(intent);

        onView(withId(R.id.action_share)).check(matches(not(isDisplayed())));
    }
}
