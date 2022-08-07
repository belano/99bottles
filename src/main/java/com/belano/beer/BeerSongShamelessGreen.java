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
        return switch (bottles) {
            case 0 -> """
                    No more bottles of beer on the wall, no more bottles of beer.
                    Go to the store and buy some more, 99 bottles of beer on the wall.
                                        
                    """;
            case 1 -> """
                    1 bottle of beer on the wall, 1 bottle of beer.
                    Take it down and pass it around, no more bottles of beer on the wall.
                                        
                    """;
            case 2 -> """
                    2 bottles of beer on the wall, 2 bottles of beer.
                    Take one down and pass it around, 1 bottle of beer on the wall.
                                        
                    """;
            default -> """
                    %d bottles of beer on the wall, %d bottles of beer.
                    Take one down and pass it around, %d bottles of beer on the wall.
                                        
                    """.formatted(bottles, bottles, bottles - 1);
        };

    }
}
