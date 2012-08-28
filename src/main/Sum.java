package main;

public class Sum extends Expression{

    public Sum(Expression augend, Expression addend) {
        super(augend, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
