package com.ss.task.configuration;


/**
 * Constants for application
 */
public class Constants {

    /**
     * Uri for current request
     */
    public static final String CURRENT_URI = "https://api.coindesk.com/v1/bpi/currentprice/%s.json";

    /**
     * Uri for period request
     */
    public static final String PERIOD_URI = "https://api.coindesk.com/v1/bpi/historical/close.json?start=%s&end=%s&currency=%s";

    /**
     * Period
     */
    public static final int PERIOD_DAYS = 30;
}
