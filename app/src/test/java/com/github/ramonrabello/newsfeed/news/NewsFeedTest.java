package com.github.ramonrabello.newsfeed.news;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by ramonrabello on 02/10/17.
 */
public class NewsFeedTest {

    @Test
    public void shouldCheckIfNewsFeedIsEmpty(){
        NewsFeed newsFeed = new NewsFeed();
        List<FeedItem> feedItems = Collections.emptyList();
        newsFeed.setFeed(feedItems);
        assertTrue(newsFeed.getFeed().isEmpty());
    }

    @Test
    public void shouldCheckIfFeedItemsWereAdded(){
        NewsFeed newsFeed = new NewsFeed();
        FeedItem firstItem = mock(FeedItem.class);
        FeedItem secondItem = mock(FeedItem.class);
        FeedItem thirdItem = mock(FeedItem.class);
        newsFeed.addItems(Arrays.asList(firstItem, secondItem, thirdItem));
        assertFalse(newsFeed.getFeed().isEmpty());
    }

    @Test
    public void shouldCheckIfFeedItemWasAdded(){
        NewsFeed newsFeed = new NewsFeed();
        FeedItem firstItem = mock(FeedItem.class);
        newsFeed.addItem(firstItem);
        assertEquals(newsFeed.getFeed().size(), 1);
    }
}
