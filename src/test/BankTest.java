package test;


import main.Bank;
import main.Money;
import main.Expression;
import main.Sum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.setRate("CHF", "USD", 2);

        Money result = bank.reduce(Money.franc(2), "USD");

        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testMixedCurrencyAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.setRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveBucks.plus(tenFrancs),"USD");

        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().getRate("USD", "USD"));
    }


    @Test
    public void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.setRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20),result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.setRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }
}
