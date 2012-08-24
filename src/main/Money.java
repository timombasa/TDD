package main;

public class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && this.getClass() == money.getClass();
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

//    public Money times(int multiplier) {
//        return new Money(amount * multiplier);
//    }

    public Money times(int multiplier){
        return null;
    }

    public String currency(){
        return currency;
    }
}