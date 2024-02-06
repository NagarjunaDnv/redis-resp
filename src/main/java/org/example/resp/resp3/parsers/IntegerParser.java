package org.example.resp.resp3.parsers;

import org.example.resp.resp3.constants.RESP3Constants;

import java.io.InputStream;

public class IntegerParser extends BaseParser<Integer> {
    protected IntegerParser(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public Integer parse() {

        try {
            StringBuilder result = new StringBuilder();
            int curByte;

            while ((curByte = inputStream.read()) != RESP3Constants.BYTE_VALUE_FOR_CR) {
                result.append((char) curByte);
            }

            // Consume the '\n' character
            curByte = inputStream.read();

            return Integer.parseInt(result.toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
