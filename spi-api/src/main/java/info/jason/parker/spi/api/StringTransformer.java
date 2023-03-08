package info.jason.parker.spi.api;

public interface StringTransformer {
    String type();

    String transform(String s);
}
