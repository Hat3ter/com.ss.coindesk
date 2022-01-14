package com.ss.task.utils;

import com.ss.task.configuration.Constants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.ss.task.models.api.response.CurrencyType;

import java.time.LocalDate;

/**
 * Utils for uri
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UriUtils {

    /**
     * Get current price uri
     *
     * @param currencyType {@link CurrencyType}
     * @return uri
     */
    public static String getCurrentPriceUri(CurrencyType currencyType) {

        return String.format(Constants.CURRENT_URI, currencyType.getCurrency());
    }

    /**
     * Get price by period uri
     *
     * @param currencyType {@link CurrencyType}
     * @param startDate    start date period
     * @param endDate      end date period
     * @return uri
     */
    public static String getPriceByPeriodUri(CurrencyType currencyType, LocalDate startDate, LocalDate endDate) {

        return String.format(Constants.PERIOD_URI, startDate, endDate, currencyType.getCurrency());
    }
}
