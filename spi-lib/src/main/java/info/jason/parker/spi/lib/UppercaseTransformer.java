package info.jason.parker.spi.lib;

import info.jason.parker.spi.api.StringTransformer;

public class UppercaseTransformer implements StringTransformer {
    @Override
    public String type() {
        return "UPPERCASE";
    }

    @Override
    public String transform(String s) {
        return s.toUpperCase();
    }
}
