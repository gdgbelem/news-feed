package com.github.ramonrabello.newsfeed.news;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ramonrabello on 28/09/17.
 */
public class FeedItemTest {

    @Test
    public void shouldCheckIfFeeItemWithThumb() throws Exception {
        FeedItem feedItem = new FeedItem();
        feedItem.setThumb("/");
        Assert.assertTrue(feedItem.withThumb());
    }
}