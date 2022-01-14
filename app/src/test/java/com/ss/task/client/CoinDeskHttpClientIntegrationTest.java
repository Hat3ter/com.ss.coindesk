package com.ss.task.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.task.configuration.Constants;
import com.ss.task.models.api.response.CurrencyType;
import com.ss.task.models.api.response.CurrentPriceCoinDeskApiResponse;
import com.ss.task.models.api.response.PeriodPriceCoinDeskApiResponse;
import org.junit.Assert;
import org.junit.Test;

import java.net.http.HttpClient;
import java.time.LocalDate;

/**
 * Integration test for {@link CoinDeskHttpClient}
 */
public class CoinDeskHttpClientIntegrationTest {


    /**
     * Integration test for {@link CurrentPriceCoinDeskApiResponse}
     */
    @Test
    public void testGetCurrentPriceCoinDeskApiResponse_shouldReturnSuccessModel() {

        var coinDeskHttpClient = new CoinDeskHttpClient<>(
                CurrentPriceCoinDeskApiResponse.class, new ObjectMapper(), HttpClient.newHttpClient());

        String uri = String.format(Constants.CURRENT_URI, "usd");
        CurrentPriceCoinDeskApiResponse result = coinDeskHttpClient.get(uri);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getDisclaimer());
        Assert.assertNotNull(result.getTimeResponse());
        Assert.assertNotNull(result.getTimeResponse().getUpdated());
        Assert.assertNotNull(result.getTimeResponse().getUpdatedIso());
        Assert.assertNotNull(result.getTimeResponse().getUpdatedUk());
        Assert.assertNotNull(result.getBpi());
        Assert.assertFalse(result.getBpi().isEmpty());
        Assert.assertNotNull(result.getBpi().get(CurrencyType.USD).getRateFloat());
        Assert.assertNotNull(result.getBpi().get(CurrencyType.USD).getRate());
        Assert.assertNotNull(result.getBpi().get(CurrencyType.USD).getCode());
        Assert.assertEquals(result.getBpi().get(CurrencyType.USD).getCode(), CurrencyType.USD.name());
        Assert.assertNotNull(result.getBpi().get(CurrencyType.USD).getDescription());
    }

    /**
     * Integration test for {@link PeriodPriceCoinDeskApiResponse}
     */
    @Test
    public void testGetPeriodPriceCoinDeskApiResponse_shouldReturnSuccessModel() {

        var coinDeskHttpClient = new CoinDeskHttpClient<>(
                PeriodPriceCoinDeskApiResponse.class, new ObjectMapper(), HttpClient.newHttpClient());

        LocalDate now = LocalDate.now();
        String uri = String.format(Constants.PERIOD_URI, now.minusDays(30), now, "usd");
        PeriodPriceCoinDeskApiResponse result = coinDeskHttpClient.get(uri);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getDisclaimer());
        Assert.assertNotNull(result.getTimeResponse());
        Assert.assertNotNull(result.getTimeResponse().getUpdated());
        Assert.assertNotNull(result.getTimeResponse().getUpdatedIso());
        Assert.assertNull(result.getTimeResponse().getUpdatedUk());
        Assert.assertNotNull(result.getBpi());
        Assert.assertFalse(result.getBpi().isEmpty());
    }
}