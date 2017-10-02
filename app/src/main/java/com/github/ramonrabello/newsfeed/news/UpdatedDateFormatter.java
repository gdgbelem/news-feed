package com.github.ramonrabello.newsfeed.news;

import com.github.ramonrabello.newsfeed.common.Formatter;

/**
 * A {@link Formatter} for displaying date information.
 */
class UpdatedDateFormatter implements Formatter<Long> {

    @Override
    public String format(Long updated){
        String updatedAsString = String.valueOf(updated);
        String date = updatedAsString.substring(6,8);
        String month = updatedAsString.substring(4,6);
        return date.concat("/").concat(month);
    }
}
