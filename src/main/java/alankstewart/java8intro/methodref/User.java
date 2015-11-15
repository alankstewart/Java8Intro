package alankstewart.java8intro.methodref;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class User {

    private final String name;
    private final int age;

    User() {
        name = "John Doe";
        age = 100;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
