package alankstewart.java8intro.repeatingannotations;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class Scheduler {

    @Role(name = "Manager")
    @Role(name = "Administrator")
    public void start() {
        // Do something ...
    }
}
