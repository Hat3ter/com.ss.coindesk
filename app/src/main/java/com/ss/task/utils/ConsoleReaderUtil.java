package com.ss.task.utils;

import com.ss.task.models.api.response.CurrencyType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Util for reading from console.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsoleReaderUtil {

    /**
     * Read currency from console
     * Warning - may return Null
     *
     * @return currency
     */
    @Nullable
    public static String readCurrency() {

        String types = Arrays.stream(CurrencyType.values()).map(Enum::name).collect(Collectors.joining(", "));
        System.out.printf("::Please enter currency code(%s) or exit%n", types);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currency;
        while (true) {
            currency = getLine(reader);
            System.out.printf("You inter next value {%s}%n", currency);
            if (CurrencyType.existsCurrencyCode(currency)) {
                break;
            } else if ("exit".equals(currency)) {
                System.out.println("::Application closed");
                return null;
            } else {
                System.out.printf("Not supported currency {%s}%n", currency);
            }
        }
        return currency;
    }

    /**
     * Get line from console, by default return empty string
     *
     * @param reader {@link BufferedReader}
     * @return line from console
     */
    private static String getLine(BufferedReader reader) {
        String result = "";
        try {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println("::Try again");
        }
        return result;
    }
}
