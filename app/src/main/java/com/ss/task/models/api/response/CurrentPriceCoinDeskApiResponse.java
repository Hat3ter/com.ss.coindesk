package com.ss.task.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * Model for current price response
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CurrentPriceCoinDeskApiResponse extends AbstractCoinDeskApiResponse {

    /**
     * Bpi
     */
    @JsonProperty("bpi")
    private Map<CurrencyType, CurrencyResponse> bpi;
}


