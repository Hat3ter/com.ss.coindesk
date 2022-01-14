package com.ss.task.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * Model for period price response
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class PeriodPriceCoinDeskApiResponse extends AbstractCoinDeskApiResponse {

    /**
     * Bpi
     */
    @JsonProperty("bpi")
    @JsonDeserialize(keyUsing = LocalDateKeyDeserializer.class)
    private Map<LocalDate, BigDecimal> bpi;
}


