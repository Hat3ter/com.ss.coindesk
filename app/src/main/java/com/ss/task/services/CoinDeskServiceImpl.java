package com.ss.task.services;

import com.ss.task.client.CoinDeskHttpClient;
import lombok.RequiredArgsConstructor;

/**
 * Implementation {@link CoinDeskService}
 *
 * @param <T>
 */
@RequiredArgsConstructor
public class CoinDeskServiceImpl<T> implements CoinDeskService<T> {

    /**
     * @see CoinDeskHttpClient
     */
    private final CoinDeskHttpClient<T> client;

    @Override
    public T get(String uri) {
        return client.get(uri);
    }
}
