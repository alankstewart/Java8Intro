package alankstewart.java8intro.functional;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static alankstewart.java8intro.functional.Transaction.Type.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class StreamsTest {

    @Test
    public void shouldGetCollectionsTransactionIds() {
        List<Transaction> collectionsTransactions = new ArrayList<>();
        for (Transaction t : getTransactions()) {
            if (t.getType() == COLLECTIONS) {
                collectionsTransactions.add(t);
            }
        }

        Collections.sort(collectionsTransactions, new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });

        int count = 0;
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : collectionsTransactions) {
            if (count < 4) {
                transactionIds.add(t.getId());
            }
            count++;
        }

        assertThat(transactionIds, contains(1, 6, 3, 5));
    }

    @Test
    public void shouldGetCollectionsTransactionIdsWithStreams() {
        List<Integer> transactionIds = getTransactions()
                .stream()
                .filter(t -> t.getType() == COLLECTIONS)
                .sorted(comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .limit(4)
                .collect(toList());

        assertThat(transactionIds, contains(1, 6, 3, 5));
    }

    private List<Transaction> getTransactions() {
        return Arrays.asList(
                new Transaction(1, BigDecimal.TEN, COLLECTIONS),
                new Transaction(2, BigDecimal.ONE, COLLECTIONS),
                new Transaction(3, new BigDecimal("5"), COLLECTIONS),
                new Transaction(4, new BigDecimal("3"), COLLECTIONS),
                new Transaction(5, new BigDecimal("4"), COLLECTIONS),
                new Transaction(6, new BigDecimal("6"), COLLECTIONS),
                new Transaction(7, BigDecimal.ONE, RTGS),
                new Transaction(8, BigDecimal.TEN, RTGS),
                new Transaction(9, new BigDecimal("5"), INTERNATIONAL),
                new Transaction(10, new BigDecimal("7"), INTERNATIONAL),
                new Transaction(11, new BigDecimal("8"), INTERNATIONAL),
                new Transaction(12, new BigDecimal("2"), DIRECT_ENTRY),
                new Transaction(13, new BigDecimal("11"), DIRECT_ENTRY),
                new Transaction(14, new BigDecimal("9"), DIRECT_ENTRY),
                new Transaction(15, new BigDecimal("12"), DIRECT_ENTRY));
    }
}
