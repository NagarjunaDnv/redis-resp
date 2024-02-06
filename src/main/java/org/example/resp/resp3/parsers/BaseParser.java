package org.example.resp.resp3.parsers;

import java.io.InputStream;

public abstract class BaseParser<T> implements IParser<T> {
    protected final InputStream inputStream;

    protected BaseParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
