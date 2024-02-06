package org.example.resp.resp3.types;

import java.util.Arrays;

public enum RESPDataType {
    SIMPLE_STRING(43),
    BULK_STRING(36),
    INTEGER(58),
    DOUBLE(44),
    ARRAY(42),
    ERROR(45);

    private int value;

    RESPDataType(int value) {
        this.value = value;
    }

    public static RESPDataType fromInt(int value) {
        return Arrays.stream(values())
                .filter(dataType -> dataType.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The data type is not supported at the moment"));
    }
}
