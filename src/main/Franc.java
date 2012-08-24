package main;


public class Franc extends Money{

    public static String currency = "CHF";

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
}
