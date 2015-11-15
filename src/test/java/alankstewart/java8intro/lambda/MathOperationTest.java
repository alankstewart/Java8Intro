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
        int value = operate(10, 5, addition);
        assertThat(value, is(15));
    }

    @Test
    public void shouldSubtractTwoIntegers() {
        MathOperation subtraction = (x, y) -> x - y;
        int value = operate(10, 5, subtraction);
        assertThat(value, is(5));
    }

    @Test
    public void shouldMultiplyTwoIntegers() {
        MathOperation multiplication = (x, y) -> x * y;
        int value = operate(10, 5, multiplication);
        assertThat(value, is(50));
    }

    @Test
    public void shouldDivideTwoIntegers() {
        MathOperation division = (x, y) -> x / y;
        int value = operate(10, 5, division);
        assertThat(value, is(2));
    }

    private int operate(int x, int y, MathOperation mathOperation) {
        return mathOperation.operation(x, y);
    }
}
