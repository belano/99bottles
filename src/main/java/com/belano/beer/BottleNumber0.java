package com.belano.beer;

public class BottleNumber0 extends BottleNumber {
    BottleNumber0() {
        super(0);
    }

    @Override
    public String quantity() {
        return "no more";
    }

    @Override
    public String action() {
        return "Go to the store and buy some more";
    }

    @Override
    public int successor() {
        return 99;
    }
}
