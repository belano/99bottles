package com.belano.beer;

public class BeerSong {

    public String singSong() {
        return sing(99, 100);
    }

    public String sing(int bottles, int numberOfVerses) {
        StringBuilder result = new StringBuilder();
        while (numberOfVerses > 0) {
            result.append(sing(bottles));
            bottles -= 1;
            numberOfVerses -= 1;
        }
        return result.toString();
    }

    private String sing(int bottles) {
        int oneDown = bottles - 1;
        return cap(pluralizeBottle(bottles)) + " of beer on the wall, " + pluralizeBottle(bottles) + " of beer.\n" +
                takeItDown(bottles) + ", " + pluralizeBottle(oneDown) + " of beer on the wall.\n\n";
    }

    private static String cap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String pluralizeBottle(int bottles) {
        if (bottles > 1) {
            return bottles + " bottles";
        } else if (bottles == 1) {
            return bottles + " bottle";
        } else if (bottles == 0) {
            return "no more bottles";
        } else {
            return "99 bottles";
        }
    }

    private static String takeItDown(int bottles) {
        if (bottles > 1) {
            return "Take one down and pass it around";
        } else if (bottles == 1) {
            return "Take it down and pass it around";
        } else {
            return "Go to the store and buy some more";
        }
    }

}
