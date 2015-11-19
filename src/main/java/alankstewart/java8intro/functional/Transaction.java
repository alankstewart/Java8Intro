package alankstewart.java8intro.functional;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class Transaction {

    public enum Type {
        COLLECTIONS, RTGS, INTERNATIONAL, DIRECT_ENTRY
    }

    private Integer id;
    private Integer value;
    private Type type;

    public Transaction(Integer id, Integer value, Type type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Transaction(id = %d, value = %d, type = %s)", id, value, type);
    }
}
