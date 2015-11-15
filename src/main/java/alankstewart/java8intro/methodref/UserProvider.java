package alankstewart.java8intro.methodref;

/**
 * Created by alanstewart on 15/11/2015.
 */
@FunctionalInterface
public interface UserProvider {

    User getUser(String name, int age);
}
