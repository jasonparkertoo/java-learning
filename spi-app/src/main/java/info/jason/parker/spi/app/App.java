package info.jason.parker.spi.app;

import info.jason.parker.spi.api.StringTransformer;

import java.util.ServiceLoader;

public class App {

    public static void main(String[] args) {
        ServiceLoader<StringTransformer> loader = ServiceLoader.load(StringTransformer.class);
        loader.reload();
        for (StringTransformer t : loader) {
            System.out.println(t.transform("jason"));
        }
    }
}
