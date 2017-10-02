package com.github.ramonrabello.newsfeed.news;

import com.github.ramonrabello.newsfeed.common.Formatter;

/**
 * A {@link Formatter} for displaying time information.
 */
class UpdatedTimeFormatter implements Formatter<Long> {

    @Override
    public String format(Long updated){
        String updatedAsString = String.valueOf(updated);
        String hour = updatedAsString.substring(8,10);
        String minutes = updatedAsString.substring(10,12);
        return hour.concat("h").concat(minutes);
    }
}
