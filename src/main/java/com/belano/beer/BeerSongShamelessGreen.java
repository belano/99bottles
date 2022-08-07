package com.belano.beer;

import java.util.Objects;

public class BeerSongShamelessGreen {

    public String singSong() {
        return verses(99, 0);
    }

    public String verses(int upper, int lower) {
        StringBuilder result = new StringBuilder();
        for (int i = upper; i >= lower; i--) {
            result.append(verse(i));
        }
        return result.toString();
    }

    public String verse(int bottles) {
        var bottleNumber = bottleNumberFor(bottles);
        var nextBottleNumber = bottleNumberFor(bottleNumber.successor());
        return """
                %s of beer on the wall, %s of beer.
                %s, %s of beer on the wall.
                                    
                """.formatted(cap(bottleNumber),
                bottleNumber,
                bottleNumber.action(),
                nextBottleNumber);
    }

    private String cap(Object o) {
        String toString = Objects.requireNonNull(o).toString();
        return toString.substring(0, 1)
                .toUpperCase() + toString.substring(1);
    }

    private BottleNumber bottleNumberFor(int number) {
        return switch (number) {
            case 0 -> new BottleNumber0();
            case 1 -> new BottleNumber1();
            default -> new BottleNumber(number);
        };
    }

}
