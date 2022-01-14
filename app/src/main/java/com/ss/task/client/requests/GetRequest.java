package com.ss.task.client.requests;

/**
 * Get request interface
 *
 * @param <T>
 */
public interface GetRequest<T> {

    /**
     * Get request
     *
     * @param uri uri
     * @return T
     */
    T get(String uri);
}
