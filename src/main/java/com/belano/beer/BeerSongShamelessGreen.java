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
        var bottleNumber = new BottleNumber(bottles);
        var nextBottleNumber = new BottleNumber(bottleNumber.successor());
        return """
                %s %s of beer on the wall, %s %s of beer.
                %s, %s %s of beer on the wall.
                                    
                """.formatted(cap(bottleNumber.quantity()),
                bottleNumber.container(),
                bottleNumber.quantity(),
                bottleNumber.container(),
                bottleNumber.action(),
                nextBottleNumber.quantity(),
                nextBottleNumber.container());
    }

    private String cap(String str) {
        return str.substring(0, 1)
                .toUpperCase() + str.substring(1);
    }

    private static class BottleNumber {
        private final int number;

        private BottleNumber(int number) {
            this.number = number;
        }

        private String container() {
            if (number == 1) {
                return "bottle";
            } else {
                return "bottles";
            }
        }

        private String pronoun() {
            if (number == 1) {
                return "it";
            } else {
                return "one";
            }
        }

        private String quantity() {
            if (number == 0) {
                return "no more";
            } else {
                return String.valueOf(number);
            }
        }

        private String action() {
            if (number == 0) {
                return "Go to the store and buy some more";
            } else {
                return "Take %s down and pass it around".formatted(pronoun());
            }
        }

        private int successor() {
            if (number == 0) {
                return 99;
            } else {
                return number - 1;
            }
        }

        public int getNumber() {
            return number;
        }
    }

}
