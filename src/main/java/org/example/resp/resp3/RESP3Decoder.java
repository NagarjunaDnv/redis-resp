package org.example.resp.resp3;

import org.example.resp.resp3.parsers.IParser;
import org.example.resp.resp3.parsers.ParserFactory;
import org.example.resp.resp3.types.RESPDataType;

import java.io.InputStream;

public class RESP3Decoder {

    public static Object decode(InputStream inputStream) {

        try {
            RESPDataType respDataType = RESPDataType.fromInt(inputStream.read());
            IParser<?> parser = ParserFactory.getParserFor(respDataType, inputStream);
            return parser.parse();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
