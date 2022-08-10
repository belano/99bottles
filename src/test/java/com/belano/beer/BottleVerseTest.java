package com.belano.beer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BottleVerseTest {

    private final VerseTemplateSupplier supplier = BottleVerse::new;

    @Test
    void testVerseGeneralRuleUpperBound() {
        Assertions.assertEquals("""
                99 bottles of beer on the wall, 99 bottles of beer.
                Take one down and pass it around, 98 bottles of beer on the wall.

                """, supplier.get(99)
                .lyrics());
    }

    @Test
    void testVerseGeneralRuleLowerBound() {
        Assertions.assertEquals("""
                3 bottles of beer on the wall, 3 bottles of beer.
                Take one down and pass it around, 2 bottles of beer on the wall.

                """, supplier.get(3)
                .lyrics());
    }

    @Test
    void testVerseSeven() {
        Assertions.assertEquals("""
                7 bottles of beer on the wall, 7 bottles of beer.
                Take one down and pass it around, 1 six-pack of beer on the wall.

                """, supplier.get(7)
                .lyrics());
    }

    @Test
    void testVerseSix() {
        Assertions.assertEquals("""
                1 six-pack of beer on the wall, 1 six-pack of beer.
                Take one down and pass it around, 5 bottles of beer on the wall.

                """, supplier.get(6)
                .lyrics());
    }

    @Test
    void testVerseTwo() {
        Assertions.assertEquals("""
                2 bottles of beer on the wall, 2 bottles of beer.
                Take one down and pass it around, 1 bottle of beer on the wall.

                """, supplier.get(2)
                .lyrics());
    }

    @Test
    void testVerseOne() {
        Assertions.assertEquals("""
                1 bottle of beer on the wall, 1 bottle of beer.
                Take it down and pass it around, no more bottles of beer on the wall.

                """, supplier.get(1)
                .lyrics());
    }


    @Test
    void testVerseZero() {
        Assertions.assertEquals("""
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.

                """, supplier.get(0)
                .lyrics());
    }
}