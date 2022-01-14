package com.ss.task.models.api.response;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Test for {@link CurrencyType}
 */
public class CurrencyTypeTest {


    /**
     * Test that currency should be in lower case
     */
    @Test
    public void testCurrencyShouldBeInLowerCase() {

        Arrays.stream(CurrencyType.values()).forEach(currencyType -> {

            assertEquals(currencyType.name().toLowerCase(Locale.ROOT), currencyType.getCurrency());
        });
    }

    /**
     * Test {@link CurrencyType#existsCurrencyCode(String)}
     */
    @Test
    public void testExistsCurrencyCode() {

        assertFalse(CurrencyType.existsCurrencyCode(null));
        assertFalse(CurrencyType.existsCurrencyCode(""));
        assertFalse(CurrencyType.existsCurrencyCode("another text"));

        assertTrue(CurrencyType.existsCurrencyCode("USD"));
        assertTrue(CurrencyType.existsCurrencyCode("EUR"));
        assertTrue(CurrencyType.existsCurrencyCode("GBP"));

        //also checked for fool user
        assertTrue(CurrencyType.existsCurrencyCode("usd"));
        assertTrue(CurrencyType.existsCurrencyCode("uSd"));
        assertTrue(CurrencyType.existsCurrencyCode("usD"));
    }
}