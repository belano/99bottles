package com.belano.beer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountDownSongTest {

    private final CountDownSong countDownSong = new CountDownSong(VerseFake::new);

    @Test
    void testVerse() {
        Assertions.assertEquals("""
                This is verse 500.

                """, countDownSong.verse(500));
    }

    @Test
    void testVerses() {
        Assertions.assertEquals("""
                This is verse 99.

                This is verse 98.
                                
                This is verse 97.

                """, countDownSong.verses(99, 97));
    }

    @Test
    void testTheWholeSong() {
        Assertions.assertEquals("""
                This is verse 47.

                This is verse 46.
                                
                This is verse 45.
                
                This is verse 44.
                                
                This is verse 43.

                """, new CountDownSong(VerseFake::new, 47, 43)
                .singSong());
    }

    private record VerseFake(int number) implements VerseTemplate {

        @Override
        public String lyrics() {
            return """
                    This is verse %d.
                                        
                    """
                    .formatted(number);
        }
    }
}