package alankstewart.java8intro.defaultmethods.multiple;

/**
 * Created by alanstewart on 15/11/2015.
 */
public interface FourWheelDrive {

    default void print() {
        System.out.println("I am a four wheel drive");
    }
}
