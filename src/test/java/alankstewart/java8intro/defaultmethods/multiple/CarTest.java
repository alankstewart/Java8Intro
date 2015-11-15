package alankstewart.java8intro.defaultmethods.multiple;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class CarTest {

    @Test
    public void car() {
        Car car = new Car();
        assertThat(4, is(car.getNumberOfWheels()));
        car.print();
    }
}
