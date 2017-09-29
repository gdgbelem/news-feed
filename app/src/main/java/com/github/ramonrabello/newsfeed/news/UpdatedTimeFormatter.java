package com.github.ramonrabello.newsfeed.news;

/**
 * Created by ramonrabello on 29/09/17.
 */

class UpdatedTimeFormatter implements UpdatedFormatter {

    @Override
    public String format(long updated){
        String updatedAsString = String.valueOf(updated);
        String hour = updatedAsString.substring(8,10);
        String minutes = updatedAsString.substring(10,12);
        return hour.concat("h").concat(minutes);
    }
}
