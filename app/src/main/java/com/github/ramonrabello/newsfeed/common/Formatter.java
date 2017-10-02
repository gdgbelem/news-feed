package com.github.ramonrabello.newsfeed.common;

/**
 * A base formatter.
 */
public interface Formatter<T> {
    String format(T type);
}
