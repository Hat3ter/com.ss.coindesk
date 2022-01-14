package com.ss.task.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Abstract coin desk response
 */
@Data
public class AbstractCoinDeskApiResponse {

    /**
     * Model with different times
     */
    @JsonProperty("time")
    private TimeResponse timeResponse;

    /**
     * Description
     */
    @JsonProperty("disclaimer")
    private String disclaimer;
}
