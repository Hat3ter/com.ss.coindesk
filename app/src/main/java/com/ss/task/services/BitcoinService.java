package com.ss.task.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.task.client.CoinDeskHttpClient;
import com.ss.task.configuration.Constants;
import com.ss.task.models.api.response.CurrencyType;
import com.ss.task.models.api.response.CurrentPriceCoinDeskApiResponse;
import com.ss.task.models.api.response.PeriodPriceCoinDeskApiResponse;
import com.ss.task.utils.ConsoleReaderUtil;
import com.ss.task.utils.UriUtils;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Common service
 */
public class BitcoinService {

    /**
     * Get bitcoin information
     */
    public void startProcess() {
        System.out.println("::Application started");

        String currency = ConsoleReaderUtil.readCurrency();
        if (Objects.isNull(currency)) {
            return;
        }

        final ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        var currentPriceClient = new CoinDeskHttpClient<>(CurrentPriceCoinDeskApiResponse.class, objectMapper, httpClient);
        var periodPriceClient = new CoinDeskHttpClient<>(PeriodPriceCoinDeskApiResponse.class, objectMapper, httpClient);

        var currentCoinDeskService = new CoinDeskServiceImpl<>(currentPriceClient);
        var periodCoinDeskService = new CoinDeskServiceImpl<>(periodPriceClient);

        CurrencyType currencyType = CurrencyType.valueOf(currency.toUpperCase(Locale.ROOT));

        var currentResponse = currentCoinDeskService.get(UriUtils.getCurrentPriceUri(currencyType));

        BigDecimal currentRate = currentResponse.getBpi().get(currencyType).getRateFloat();
        System.out.printf("::Current rate %s for currency %s%n", currentRate, currencyType.getCurrency());

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(Constants.PERIOD_DAYS);
        String urlByPeriod = UriUtils.getPriceByPeriodUri(currencyType, startDate, endDate);
        var periodResponse = periodCoinDeskService.get(urlByPeriod);

        getHighestRate(periodResponse);
        getLowestRate(periodResponse);

        System.out.println("::Application stopped");
    }

    /**
     * Get lowest rate
     *
     * @param periodResponse {@link PeriodPriceCoinDeskApiResponse}
     */
    private void getLowestRate(PeriodPriceCoinDeskApiResponse periodResponse) {

        periodResponse.getBpi().entrySet().stream().min(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.printf("::Lowest rate in 30 days %s on date %s%n", entry.getValue(), entry.getKey()));
    }

    /**
     * Get highest rate
     *
     * @param periodResponse {@link PeriodPriceCoinDeskApiResponse}
     */
    private void getHighestRate(PeriodPriceCoinDeskApiResponse periodResponse) {

        periodResponse.getBpi().entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.printf("::Highest rate in 30 days %s on date %s%n", entry.getValue(), entry.getKey()));
    }

}
