package com.belano.beer;

public class BeerSongShamelessGreen {

    private final VerseTemplateSupplier verseTemplate;

    public BeerSongShamelessGreen(VerseTemplateSupplier verseTemplate) {
        this.verseTemplate = verseTemplate;
    }

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
        return verseTemplate.get(bottles).lyrics();
    }

}
