package info.jason.parker.spi.lib;

import info.jason.parker.spi.api.StringTransformer;

public class CapitalizeTransformer implements StringTransformer {
    @Override
    public String type() {
        return "CAPITALIZE";
    }

    @Override
    public String transform(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
