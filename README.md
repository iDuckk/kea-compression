# KEA Compression Library

**KEA** (Key-Encoded Alternation) — custom recursive bit compression algorithm implemented in Java.

## Features
- Recursive binary-tree encoding
- Full bit-level decompression
- Cross-platform compatibility

## Usage

```java
KEAEncoder encoder = new KEAEncoder();
KEANode compressed = encoder.encode(bits);

KEADecoder decoder = new KEADecoder();
List<Integer> result = decoder.decode(compressed);
```

## License
MIT
