package main;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money reduce(Expression source, String to){
        return source.reduce(this, to);
    }

    public int rate(String from, String to) {
        return (from.equals("CHF") && to.equals("USD"))
                ? 2
                : 1;
    }

    public void setRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

    public int getRate(String from, String to){
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to){
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object other){
            Pair pair = (Pair) other;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}