package com.belano.beer;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import static org.reflections.ReflectionUtils.*;
import static org.reflections.scanners.Scanners.SubTypes;

public class BottleNumberFactory {

    private static final Reflections reflections = new Reflections("com.belano.beer");
    private static Set<BottleNumber> bottleNumberHandlers = new HashSet<>();

    static {
        registerHandlers();
    }

    public static BottleNumber createFor(int number) {
        return bottleNumberHandlers.stream()
                .filter(bottleNumber -> bottleNumber.handles(number))
                .findFirst()
                .orElse(new BottleNumber(number));
    }

    private static void registerHandlers() {
        reflections.get(SubTypes.of(BottleNumber.class)
                        .asClass())
                .forEach(clazz -> {
                    Constructor<BottleNumber> constructor = getFirst(
                            getConstructors(clazz, withModifier(Modifier.PUBLIC).and(withParametersCount(0))), null);
                    assert constructor != null : "No default constructor is found from " + clazz.getName();
                    BottleNumber handler = createNewInstance(constructor);
                    bottleNumberHandlers.add(handler);
                });
    }

    private static <T> T getFirst(Iterable<T> iterable, T defaultValue) {
        return iterable.iterator()
                .hasNext() ? iterable.iterator()
                .next() : defaultValue;
    }

    private static BottleNumber createNewInstance(Constructor<BottleNumber> constructor) {
        try {
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
