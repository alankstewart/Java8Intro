package alankstewart.java8intro.functional;

import org.junit.Test;

import java.util.*;

import static alankstewart.java8intro.functional.Transaction.Type.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class StreamsTest {

    private static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(1, 10, COLLECTIONS),
            new Transaction(2, 1, COLLECTIONS),
            new Transaction(3, 5, COLLECTIONS),
            new Transaction(4, 3, COLLECTIONS),
            new Transaction(5, 4, COLLECTIONS),
            new Transaction(6, 6, COLLECTIONS),
            new Transaction(7, 1, RTGS),
            new Transaction(8, 10, RTGS),
            new Transaction(9, 5, INTERNATIONAL),
            new Transaction(10, 7, INTERNATIONAL),
            new Transaction(11, 8, INTERNATIONAL),
            new Transaction(12, 2, DIRECT_ENTRY),
            new Transaction(13, 11, DIRECT_ENTRY),
            new Transaction(14, 12, DIRECT_ENTRY),
            new Transaction(15, 15, DIRECT_ENTRY));

    @Test
    public void shouldGetCollectionsTransactionIds() {
        List<Transaction> collectionsTransactions = new ArrayList<>();
        for (Transaction t : TRANSACTIONS) {
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
        List<Integer> transactionIds = TRANSACTIONS
                .stream()
                .filter(t -> t.getType() == COLLECTIONS)
                .sorted(comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .limit(4)
                .collect(toList());

        assertThat(transactionIds, contains(1, 6, 3, 5));
    }

    @Test
    public void shouldFindAndPrintAnyRtgsTransactions() {
        TRANSACTIONS.stream()
                .filter(t -> t.getType() == RTGS)
                .findAny()
                .ifPresent(System.out::println);
    }

    @Test
    public void shouldSumValues() {
        int sum = TRANSACTIONS.stream()
                .mapToInt(Transaction::getValue)
                .sum();

        assertThat(sum, is(100));
    }
}
