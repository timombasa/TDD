package test;


import main.Bank;
import main.Money;
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
}
