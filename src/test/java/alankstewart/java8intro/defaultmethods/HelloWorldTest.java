package alankstewart.java8intro.defaultmethods;

import org.junit.Test;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class HelloWorldTest {

    @Test
    public void shouldPrintHelloWorldAndHi() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.saySomething();
        helloWorld.sayHi();
        SomeInterface.sayGoodbye();
    }
}
