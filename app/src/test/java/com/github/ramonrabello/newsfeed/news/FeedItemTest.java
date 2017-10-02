package com.github.ramonrabello.newsfeed.news;

import android.os.Parcel;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by ramonrabello on 28/09/17.
 */
public class FeedItemTest {

    @Test
    public void shouldCheckIfFeeItemWithThumb() throws Exception {
        Parcel parcel = mock(Parcel.class);
        FeedItem feedItem = new FeedItem(parcel);
        feedItem.setThumb("/");
        assertTrue(feedItem.withThumb());
    }

    @Test
    public void shouldCheckIfFeeItemWithShareUrl() throws Exception {
        Parcel parcel = mock(Parcel.class);
        FeedItem feedItem = new FeedItem(parcel);
        feedItem.setShareUrl("/");
        assertTrue(feedItem.withShareUrl());
    }

    @Test
    public void shouldCheckIfFeeItemOfTypeNews() throws Exception {
        Parcel parcel = mock(Parcel.class);
        FeedItem feedItem = new FeedItem(parcel);
        feedItem.setType("news");
        assertEquals(feedItem.getType(), "news");
    }
}