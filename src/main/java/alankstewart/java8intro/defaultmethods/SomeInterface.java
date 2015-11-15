package alankstewart.java8intro.defaultmethods;

/**
 * Created by alanstewart on 15/11/2015.
 */
public interface SomeInterface {

    void saySomething();

    default void sayHi() {
        System.out.println("Hi!");
    }

    static void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
