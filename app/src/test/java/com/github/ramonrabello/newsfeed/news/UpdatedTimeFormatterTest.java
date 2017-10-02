package com.github.ramonrabello.newsfeed.news;

import com.github.ramonrabello.newsfeed.common.Formatter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link UpdatedTimeFormatter}.
 */
public class UpdatedTimeFormatterTest {
    @Test
    public void shouldCheckIfUpdatedWasFormmatedAsTime(){
        long updated = 20171001222036L;
        FeedItem feedItem = mock(FeedItem.class);
        when(feedItem.getUpdated()).thenReturn(updated);

        Formatter<Long> formatter = new UpdatedTimeFormatter();
        String expected = "22h20";
        String actual = formatter.format(feedItem.getUpdated());
        assertEquals(expected, actual);
    }
}
