package com.github.ramonrabello.newsfeed.news;

/**
 * Created by ramonrabello on 29/09/17.
 */

class UpdatedDateFormatter implements UpdatedFormatter {

    @Override
    public String format(long updated){
        String updatedAsString = String.valueOf(updated);
        String date = updatedAsString.substring(6,8);
        String month = updatedAsString.substring(4,6);
        return date.concat("/").concat(month);
    }
}
