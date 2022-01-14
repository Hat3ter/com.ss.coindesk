package com.ss.task.services;

/**
 * Coin desk service
 *
 * @param <T>
 */
public interface CoinDeskService<T> {

    /**
     * Get <T> from API
     *
     * @param uri uri
     * @return <T>
     */
    T get(String uri);
}
