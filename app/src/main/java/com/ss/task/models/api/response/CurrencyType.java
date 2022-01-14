package com.ss.task.models.api.response;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Currency types
 */
@Getter
public enum CurrencyType {

    /**
     * usd
     */
    USD("usd"),

    /**
     * eur
     */
    EUR("eur"),

    /**
     * gbp
     */
    GBP("gbp");

    /**
     * currency value
     */
    private final String currency;

    /**
     * Constructor
     *
     * @param currency currency
     */
    CurrencyType(String currency) {

        this.currency = currency;
    }


    /**
     * Exists currency code?
     *
     * @param code currency code
     * @return true/false
     */
    public static boolean existsCurrencyCode(String code) {
        var checkedString = Optional.ofNullable(code).map(String::trim).orElse("");
        return Arrays.stream(CurrencyType.values())
                .filter(Objects::nonNull)
                .anyMatch(currencyType -> currencyType.name().equalsIgnoreCase(checkedString));
    }
}
