package com.ss.task.utils;

import com.ss.task.models.api.response.CurrencyType;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test for {@link ConsoleReaderUtil}
 */
public class ConsoleReaderUtilTest {


    /**
     * Test exit case
     */
    @Test
    public void testReadCurrencyWhenExitCase() {

        System.setIn(new ByteArrayInputStream("exit".getBytes()));
        String shouldBeNull = ConsoleReaderUtil.readCurrency();
        assertNull(shouldBeNull);
    }

    /**
     * Test for all currency types
     */
    @Test
    public void testReadCurrencyWhenFoundCurrency() {

        Arrays.asList(CurrencyType.values()).forEach(currencyType -> {

            InputStream inputStream = System.in;
            System.setIn(new ByteArrayInputStream(currencyType.getCurrency().getBytes()));
            String stringCurrency = ConsoleReaderUtil.readCurrency();
            assertEquals(currencyType.getCurrency(), stringCurrency);

            System.setIn(inputStream);
        });
    }
}