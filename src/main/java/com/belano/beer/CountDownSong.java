package com.belano.beer;

public class CountDownSong {

    private final VerseTemplateSupplier verseTemplate;
    private final int max;
    private final int min;

    public CountDownSong(VerseTemplateSupplier verseTemplate, int max, int min) {
        this.verseTemplate = verseTemplate;
        this.max = max;
        this.min = min;
    }

    public CountDownSong(VerseTemplateSupplier verseTemplate) {
        this(verseTemplate, 999999, 0);
    }

    public String singSong() {
        return verses(max, min);
    }

    public String verses(int upper, int lower) {
        StringBuilder result = new StringBuilder();
        for (int i = upper; i >= lower; i--) {
            result.append(verse(i));
        }
        return result.toString();
    }

    public String verse(int bottles) {
        return verseTemplate.get(bottles).lyrics();
    }

}
