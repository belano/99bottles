package com.belano.beer;

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
        return """
                %s %s of beer on the wall, %s %s of beer.
                %s, %s %s of beer on the wall.
                                    
                """.formatted(cap(quantity(bottles)),
                container(bottles),
                quantity(bottles),
                container(bottles),
                action(bottles),
                quantity(successor(bottles)),
                container(successor(bottles)));
    }

    private String container(int number) {
        if (number == 1) {
            return "bottle";
        } else {
            return "bottles";
        }
    }

    private String pronoun(int number) {
        if (number == 1) {
            return "it";
        } else {
            return "one";
        }
    }

    private String quantity(int number) {
        if (number == 0) {
            return "no more";
        } else {
            return String.valueOf(number);
        }
    }

    private String cap(String str) {
        return str.substring(0, 1)
                .toUpperCase() + str.substring(1);
    }

    private String action(int number) {
        if (number == 0) {
            return "Go to the store and buy some more";
        } else {
            return "Take %s down and pass it around".formatted(pronoun(number));
        }
    }

    private int successor(int number) {
        if (number == 0) {
            return 99;
        } else {
            return number - 1;
        }
    }
}
