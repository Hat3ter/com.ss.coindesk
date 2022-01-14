package com.ss.task.parsers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parser for iso
 */
public class IsoOffsetDeserializer extends JsonDeserializer<OffsetDateTime> {

    /**
     * Formatter
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @SneakyThrows
    @Override
    public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context) {

        return OffsetDateTime.parse(parser.getText(), this.formatter);
    }
}
