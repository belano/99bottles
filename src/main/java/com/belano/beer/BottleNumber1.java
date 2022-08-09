package com.belano.beer;

public class BottleNumber1 extends BottleNumber {
    public BottleNumber1() {
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

    public boolean handles(int number) {
        return number == 1;
    }
}
