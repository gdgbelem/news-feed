package com.github.ramonrabello.newsfeed.news;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import com.github.ramonrabello.newsfeed.MainActivity;
import com.github.ramonrabello.newsfeed.R;
import com.github.ramonrabello.newsfeed.common.espresso.idlingresource.ElapsedTimeIdlingResource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasValue;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.intent.matcher.UriMatchers.hasHost;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by ramonrabello on 02/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class NewsFeedFragmentTest {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void whenActivityLaunched_shouldCheckViewsVisibility(){
        onView(withId(R.id.news_recycler_view)).check(matches(isDisplayed()));
        onView(withId(R.id.loading_progress)).check(matches(not(isDisplayed())));
    }

    @Test
    public void whenFeedItemClicked_shouldCheckIfIntentExtrasHaveFeedItem(){
        long waitingTime = DateUtils.MINUTE_IN_MILLIS;

        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        // Now we wait
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        // click on first item
        onView(withId(R.id.news_recycler_view)).perform(actionOnItemAtPosition(0, click()));
        intended(hasExtras(hasEntry(equalTo("feed.item"), hasValue(any(FeedItem.class)))));

        // clean up
        Espresso.unregisterIdlingResources(idlingResource);
    }
}
