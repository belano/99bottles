package com.belano.beer;

public class BottleNumber1 extends BottleNumber {
    BottleNumber1() {
        super(1);
    }

    @Override
    public String container() {
        return "bottle";
    }

    @Override
    public String pronoun() {
        return "it";
    }
}
