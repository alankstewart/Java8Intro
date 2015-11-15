package alankstewart.java8intro.defaultmethods;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class HelloWorld implements SomeInterface {

    @Override
    public void saySomething() {
        System.out.println("Hello world!");
    }
}
