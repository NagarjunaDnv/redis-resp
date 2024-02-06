package org.example.resp.resp3;

import java.security.cert.CRL;
import java.util.List;
import java.util.Map;

public class RESP3Encoder {
    private static final String CRLF = "\r\n";

    public static String encode(List<String> commands) {

        StringBuilder encodedCommand = new StringBuilder();

        //Example -> It starts with "*2\r\n"
        encodedCommand
                .append("*")
                .append(commands.size())
                .append(CRLF);

        //Now, for each value in command,
        for(String command: commands) {
            encodedCommand
                    .append("$")
                    .append(command.getBytes().length)
                    .append(CRLF)
                    .append(command)
                    .append(CRLF);
        }

        return encodedCommand.toString();
    }

    public static String encodeError(String message) {
        return "-" + message + CRLF;
    }

    public static String encodeSimpleString(String message) {
        return "+" + message + CRLF;
    }

    public static String encodeBulkString(String message) {
        return "$" + message.getBytes().length + CRLF + message + CRLF;
    }

    public static String encodeInteger(long value) {

        StringBuilder result = new StringBuilder();
        result.append(":");

        if(value < 0) {
            result.append("-");
        }

        result.append(Math.abs(value)).append(CRLF);

        return result.toString();
    }

    public static String encodeDouble(Double value) {

        StringBuilder result = new StringBuilder();
        result.append(",");

        if(value < 0) {
            result.append("-");
        }

        result.append(Math.abs(value)).append(CRLF);

        return result.toString();
    }

    public static String encodeNull() {
        return "_" + CRLF;
    }
}
