package com.ss.task.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Currency response model
 */
@Data
public class CurrencyResponse {

    /**
     * Code currency
     */
    @JsonProperty("code")
    private String code;

    /**
     * Rate text
     */
    @JsonProperty("rate")
    private String rate;

    /**
     * Description
     */
    @JsonProperty("description")
    private String description;

    /**
     * Rate float
     */
    @JsonProperty("rate_float")
    private BigDecimal rateFloat;
}
