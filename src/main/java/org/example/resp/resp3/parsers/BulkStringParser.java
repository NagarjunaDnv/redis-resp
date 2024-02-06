package org.example.resp.resp3.parsers;

import org.example.resp.resp3.constants.RESP3Constants;
import org.example.resp.resp3.exceptions.ProtocolException;

import java.io.InputStream;

public class BulkStringParser extends BaseParser<String> {

    protected BulkStringParser(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public String parse() {

        try {
            int length = new IntegerParser(inputStream).parse();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                result.append((char) inputStream.read());
            }

            if(inputStream.read() != RESP3Constants.BYTE_VALUE_FOR_CR) {
                throw new ProtocolException("Expected CR");
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
