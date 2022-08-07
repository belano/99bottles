package com.belano.beer;

class BottleNumber {
    private final int number;

    BottleNumber(int number) {
        this.number = number;
    }

    public static BottleNumber createFor(int number) {
        return switch (number) {
            case 0 -> new BottleNumber0();
            case 1 -> new BottleNumber1();
            case 6 -> new BottleNumber6();
            default -> new BottleNumber(number);
        };
    }

    public String container() {
        return "bottles";
    }

    public String pronoun() {
        return "one";
    }

    public String quantity() {
        return String.valueOf(number);
    }

    public String action() {
        return "Take %s down and pass it around".formatted(pronoun());
    }

    public BottleNumber successor() {
        return createFor(number - 1);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return quantity() + " " + container();
    }
}
