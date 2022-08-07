package com.belano.beer;

public class BottleNumber6 extends BottleNumber {
    BottleNumber6() {
        super(6);
    }

    @Override
    public String container() {
        return "six-pack";
    }

    @Override
    public String quantity() {
        return "1";
    }
}
