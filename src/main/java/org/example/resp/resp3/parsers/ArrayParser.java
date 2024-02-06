package org.example.resp.resp3.parsers;

import org.example.resp.resp3.RESP3Decoder;

import java.io.InputStream;
import java.util.List;

public class ArrayParser extends BaseParser<Object[]> {
    protected ArrayParser(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public Object[] parse() {

        //First byte denotes the size of the array
        int size = new IntegerParser(inputStream).parse();

        Object[] result = new Object[size];

        for(int i = 0; i < size; i++) {
            result[i] = RESP3Decoder.decode(inputStream);
        }

        return result;
    }
}
