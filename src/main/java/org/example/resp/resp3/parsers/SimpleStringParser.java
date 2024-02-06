package org.example.resp.resp3.parsers;

import org.example.resp.resp3.constants.RESP3Constants;
import org.example.resp.resp3.exceptions.ProtocolException;

import java.io.InputStream;

public class SimpleStringParser extends BaseParser<String> {

    protected SimpleStringParser(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public String parse() {
        try {
            StringBuilder result = new StringBuilder();
            int curByte;

            while((curByte = inputStream.read()) != RESP3Constants.BYTE_VALUE_FOR_CR) {
                result.append((char) curByte);
            }

            if(inputStream.read() != RESP3Constants.BYTE_VALUE_FOR_LF) {
                throw new ProtocolException("Expected LF");
            }

            return result.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
