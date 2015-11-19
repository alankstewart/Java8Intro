package alankstewart.java8intro.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class DateTimeDemo {

    public static void main(String[] args) {
        new DateTimeDemo().createDateTimes();
    }

    public void createDateTimes() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime thePast = now.withDayOfMonth(10).withYear(2014);
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.DAYS);
        System.out.println(yetAnother);

        Instant start = Instant.now();
        // Do something
        Instant stop = Instant.now();
        long elapsed = Duration.between(start, stop).toNanos();
    }
}
