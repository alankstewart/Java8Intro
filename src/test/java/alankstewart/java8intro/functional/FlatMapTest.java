package alankstewart.java8intro.functional;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class FlatMapTest {

    @Test
    public void shouldPrintWords() throws IOException {
        Files.lines(Paths.get("stuff.txt"))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                // .distinct()
                .forEach(System.out::println);
    }
}
