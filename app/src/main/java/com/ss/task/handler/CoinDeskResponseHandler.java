package com.ss.task.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

/**
 * Handler for parsing response
 *
 * @param <T>
 */
public class CoinDeskResponseHandler<T> implements HttpResponse.BodyHandler<Supplier<T>> {

    /**
     * Response class
     */
    private final Class<T> wClass;

    /**
     * @see ObjectMapper
     */
    private final ObjectMapper objectMapper;

    /**
     * Constructor
     *
     * @param wClass       response class
     * @param objectMapper {@link ObjectMapper}
     */
    public CoinDeskResponseHandler(Class<T> wClass, ObjectMapper objectMapper) {

        this.wClass = wClass;
        this.objectMapper = objectMapper;
    }

    @Override
    public HttpResponse.BodySubscriber<Supplier<T>> apply(HttpResponse.ResponseInfo responseInfo) {

        return HttpResponse.BodySubscribers
                .mapping(HttpResponse.BodySubscribers.ofInputStream(), inputStream -> () -> {
                    try (InputStream stream = inputStream) {

                        return objectMapper.readValue(stream, wClass);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
    }

}
