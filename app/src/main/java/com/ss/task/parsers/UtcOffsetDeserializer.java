package com.ss.task.parsers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 * Parser for utc
 */
public class UtcOffsetDeserializer extends JsonDeserializer<OffsetDateTime> {

    /**
     * Formatter
     */
    private final static DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
            .appendPattern("MMM d, yyyy HH:mm:ss 'UTC'").toFormatter(Locale.ENGLISH);

    @SneakyThrows
    @Override
    public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context) {

        LocalDateTime parse = LocalDateTime.parse(parser.getText(), formatter);
        return OffsetDateTime.of(parse, ZoneOffset.UTC);
    }
}
