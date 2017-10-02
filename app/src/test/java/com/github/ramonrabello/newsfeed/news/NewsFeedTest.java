package com.github.ramonrabello.newsfeed.news;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

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
    public void shouldCheckIfNewsFeedIsNotEmpty(){
        NewsFeed newsFeed = new NewsFeed();
        FeedItem firstItem = mock(FeedItem.class);
        FeedItem secondItem = mock(FeedItem.class);
        FeedItem thirdItem = mock(FeedItem.class);
        newsFeed.getFeed().add(firstItem);
        newsFeed.getFeed().add(secondItem);
        newsFeed.getFeed().add(thirdItem);
        assertFalse(newsFeed.getFeed().isEmpty());
    }
}
