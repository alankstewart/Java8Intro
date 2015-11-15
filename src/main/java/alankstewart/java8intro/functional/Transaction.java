package alankstewart.java8intro.functional;

import java.math.BigDecimal;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class Transaction {

    public enum Type {
        COLLECTIONS, RTGS, INTERNATIONAL, DIRECT_ENTRY
    }

    private int id;
    private BigDecimal value;
    private Type type;

    public Transaction(int id, BigDecimal value, Type type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }
}
