package main;

public abstract class Expression {

    protected Expression augend;
    protected Expression addend;

    public Expression(){
        this.augend = null;
        this.addend = null;
    }

    public Expression(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount
                + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public abstract Expression times(int multiplier);
}
