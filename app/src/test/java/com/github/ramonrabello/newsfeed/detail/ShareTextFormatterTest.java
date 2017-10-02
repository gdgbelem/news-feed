package com.github.ramonrabello.newsfeed.detail;

import com.github.ramonrabello.newsfeed.news.FeedItem;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ShareTextFormatter}.
 */
public class ShareTextFormatterTest {

    @Test
    public void shouldCheckIfShareTextIsCorrect(){
        FeedItem feedItem = mock(FeedItem.class);

        // mocking feed item values
        when(feedItem.getTitle()).thenReturn("This is a test feed item title");
        when(feedItem.getShareUrl()).thenReturn("http://www.uol.com/bxAzdwk");

        ShareTextFormatter shareTextFormatter = new ShareTextFormatter();
        String expected = "This is a test feed item title. Veja mais no News Feed. Acesse: http://www.uol.com/bxAzdwk";
        String actual = shareTextFormatter.format(feedItem);
        assertEquals(expected, actual);
    }
}
