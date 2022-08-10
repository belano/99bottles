package com.belano.beer;

import java.util.Objects;

public class BottleVerse implements VerseTemplate {
    private final BottleNumber bottleNumber;

    public BottleVerse(int number) {
        this(BottleNumber.createFor(number));
    }

    public BottleVerse(BottleNumber bottleNumber) {
        this.bottleNumber = bottleNumber;
    }

    @Override
    public String lyrics() {
        return """
                %s of beer on the wall, %s of beer.
                %s, %s of beer on the wall.
                                    
                """.formatted(cap(bottleNumber),
                bottleNumber,
                bottleNumber.action(),
                bottleNumber.successor());
    }

    private String cap(Object o) {
        String toString = Objects.requireNonNull(o)
                .toString();
        return toString.substring(0, 1)
                .toUpperCase() + toString.substring(1);
    }
}
