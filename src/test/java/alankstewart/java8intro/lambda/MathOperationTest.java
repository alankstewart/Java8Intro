package alankstewart.java8intro.lambda;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class MathOperationTest {

    @Test
    public void shouldAddTwoIntegers() {
        MathOperation addition = (x, y) -> x + y;
        assertThat(15, is(operate(10, 5, addition)));
    }

    @Test
    public void shouldSubtractTwoIntegers() {
        MathOperation subtraction = (x, y) -> x - y;
        assertThat(5, is(operate(10, 5, subtraction)));
    }

    @Test
    public void shouldMultiplyTwoIntegers() {
        MathOperation multiplication = (x, y) -> x * y;
        assertThat(50, is(operate(10, 5, multiplication)));
    }

    @Test
    public void shouldDivideTwoIntegers() {
        MathOperation division = (x, y) -> x / y;
        assertThat(2, is(operate(10, 5, division)));
    }

    private int operate(int x, int y, MathOperation mathOperation) {
        return mathOperation.operation(x, y);
    }
}
