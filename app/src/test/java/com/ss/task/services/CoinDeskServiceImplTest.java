package com.ss.task.services;

import com.ss.task.client.CoinDeskHttpClient;
import org.junit.Test;
import org.mockito.Mockito;
import com.ss.task.models.api.response.CurrentPriceCoinDeskApiResponse;
import com.ss.task.models.api.response.PeriodPriceCoinDeskApiResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test for {@link CoinDeskServiceImpl}
 */
public class CoinDeskServiceImplTest {

    /**
     * Test get {@link CurrentPriceCoinDeskApiResponse}
     */
    @Test
    public void testGetCurrentPriceCoinDeskApiResponse() {

        var mockedClient = Mockito.mock(CoinDeskHttpClient.class);
        var service = new CoinDeskServiceImpl<CurrentPriceCoinDeskApiResponse>(mockedClient);

        Mockito.when(service.get("string")).thenReturn(new CurrentPriceCoinDeskApiResponse());

        CurrentPriceCoinDeskApiResponse response = service.get("string");

        assertNotNull(response);
    }

    /**
     * Test get {@link PeriodPriceCoinDeskApiResponse}
     */
    @Test
    public void testGetPeriodPriceCoinDeskApiResponse() {

        var mockedClient = Mockito.mock(CoinDeskHttpClient.class);
        var service = new CoinDeskServiceImpl<PeriodPriceCoinDeskApiResponse>(mockedClient);

        Mockito.when(service.get("string")).thenReturn(new PeriodPriceCoinDeskApiResponse());

        PeriodPriceCoinDeskApiResponse response = service.get("string");

        assertNotNull(response);
    }
}