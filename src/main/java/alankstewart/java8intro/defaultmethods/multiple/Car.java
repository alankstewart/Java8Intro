package alankstewart.java8intro.defaultmethods.multiple;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class Car implements Vehicle, FourWheelDrive {

    @Override
    public int getNumberOfWheels() {
        return 4;
    }

    @Override
    public void print() {
        Vehicle.super.print();
        FourWheelDrive.super.print();
        System.out.println("I am a car");
    }
}
