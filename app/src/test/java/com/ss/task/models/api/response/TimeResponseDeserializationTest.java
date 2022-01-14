package com.ss.task.models.api.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test deserialization {@link TimeResponse}
 */
public class TimeResponseDeserializationTest {

    private static final String TIME_RESPONSE = "{\n" +
            "\"updated\": \"Jan 14, 2022 10:51:00 UTC\",\n" +
            "\"updatedISO\": \"2022-01-14T10:51:00+00:00\",\n" +
            "\"updateduk\": \"Jan 14, 2022 at 10:51 GMT\"\n" +
            "}";

    /**
     * Test deserialization {@link TimeResponse}
     *
     * @throws JsonProcessingException exception
     */
    @Test
    public void test() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        TimeResponse timeResponse = objectMapper.readValue(TIME_RESPONSE, TimeResponse.class);
        assertNotNull(timeResponse.getUpdated());
        assertNotNull(timeResponse.getUpdatedIso());
        assertNotNull(timeResponse.getUpdatedUk());
    }
}