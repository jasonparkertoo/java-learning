package info.jason.parker.spi.api;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class StringTransformers {
    public static List<StringTransformer> getAll() {
        return ServiceLoader.load(StringTransformer.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    public static StringTransformer get(String name) {
        return ServiceLoader.load(StringTransformer.class).stream()
                .filter(p -> p.get().type().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow()
                .get();
    }
}
