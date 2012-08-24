package main;


public class Dollar extends Money{

    public static String currency = "USD";

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier, currency);
    }   
}
