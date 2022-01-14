package com.ss.task.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ss.task.parsers.GmtOffsetDeserializer;
import com.ss.task.parsers.UtcOffsetDeserializer;
import lombok.Data;
import com.ss.task.parsers.IsoOffsetDeserializer;

import java.time.OffsetDateTime;

/**
 * Response with times
 */
@Data
public class TimeResponse {

    /**
     * Updated "Jan 13, 2022 20:29:00 UTC"
     */
    @JsonDeserialize(using = UtcOffsetDeserializer.class)
    @JsonProperty("updated")
    private OffsetDateTime updated;

    /**
     * Updated iso "2022-01-13T20:29:00+00:00"
     */
    @JsonDeserialize(using = IsoOffsetDeserializer.class)
    @JsonProperty("updatedISO")
    private OffsetDateTime updatedIso;

    /**
     * Updated "Jan 13, 2022 at 20:29 GMT"
     */
    @JsonDeserialize(using = GmtOffsetDeserializer.class)
    @JsonProperty("updateduk")
    private OffsetDateTime updatedUk;
}

