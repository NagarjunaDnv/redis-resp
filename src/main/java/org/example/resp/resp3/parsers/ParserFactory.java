package org.example.resp.resp3.parsers;

import org.example.resp.resp3.types.RESPDataType;

import java.io.InputStream;

public class ParserFactory {

    public static IParser<?> getParserFor(RESPDataType respDataType, InputStream inputStream) {
        return switch (respDataType) {
            case SIMPLE_STRING, ERROR -> new SimpleStringParser(inputStream);
            case BULK_STRING -> new BulkStringParser(inputStream);
            case INTEGER -> new IntegerParser(inputStream);
            case DOUBLE -> null;
            case ARRAY -> new ArrayParser(inputStream);
        };

    }
}
