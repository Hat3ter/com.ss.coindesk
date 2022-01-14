package com.ss.task.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import com.ss.task.client.requests.GetRequest;
import com.ss.task.handler.CoinDeskResponseHandler;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Http client for CoinDesk
 *
 * @param <T>
 */
@RequiredArgsConstructor
public class CoinDeskHttpClient<T> implements GetRequest<T> {

    /**
     * Logger
     */
    private static final Logger LOG = Logger.getLogger(CoinDeskHttpClient.class.getName());

    /**
     * Class type T
     */
    private final Class<T> tClass;

    /**
     * @see ObjectMapper
     */
    private final ObjectMapper objectMapper;

    /**
     * @see HttpClient
     */
    private final HttpClient httpClient;

    @Nullable
    public T get(String uri) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            Supplier<T> body = httpClient
                    .send(request, new CoinDeskResponseHandler<>(tClass, objectMapper))
                    .body();
            return body.get();
        } catch (InterruptedException | IOException e) {
            String msg = String.format("Fetched exception when client invoke %s", e.getMessage());
            LOG.warning(msg);
        }
        return null;
    }
}
