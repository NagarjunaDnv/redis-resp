# Redis RESP Library

## Description

This Java library provides utilities for encoding and decoding strings using the Redis Serialization Protocol (RESP) version 3.

## Usage

### Manual Installation

1. Clone the repository:

    ```
    git clone https://github.com/NagarjunaDnv/redis-resp.git
    ```

2. Navigate to the project directory:

    ```
    cd redis-resp
    ```

### Gradle Configuration

In your project's `build.gradle` file, add the following dependency:

```groovy
implementation 'org.example:resp:1.0-SNAPSHOT'
```

In your `settings.gradle` file, add the following:

```groovy
if (new File('../resp').exists()) {
    includeBuild('../resp') {
        dependencySubstitution {
            substitute module('org.example:resp') using project(':')
        }
    }
}
```

## Usage

Now you can use the `RESP3Encoder` &  `RESP3Decoder` class to encode and decode RESP3 protocol strings in your project.

```java
import org.example.resp.resp3.RESP3Encoder;

public class Main {
    public static void main(String[] args) {
        String encodedMessage = RESP3Encoder.encode(List.of("GET", "hello"));
        System.out.println("Encoded: " + encodedMessage);
    }
}
```

```java
import org.example.resp.resp3.RESP3Decoder;

public class Main {
    public static void main(String[] args) {
        String input = "*2\r\n$3\r\nfoo\r\n$3\r\nbar\r\n";
        Object decodedMessage = RESP3Decoder.decode(new ByteArrayInputStream(input.getBytes()));
    }
}
```

## Support

For any questions or issues, please open an issue on the [GitHub repository](https://github.com/NagarjunaDnv/redis-resp).
