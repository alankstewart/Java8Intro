package alankstewart.java8intro.methodref;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class UserProviderTest {

    @Test
    public void shouldCreateUser() {
        // When the compile encounters User::new, it infers the right constructor to call based on the context
        // in which the constructor reference appears. Here, UserProvider provider provides this context.
        // Because this functional interface supplies a single abstract method whose parameter list matches the
        // second User constructor, the compiler chooses that constructor. The constructor is then
        // called (and the User object returned) by the subsequent getUser() method call.
        UserProvider provider = User::new;
        User user = provider.getUser("Foo Bar", 25);
        System.out.printf("Name: %s%n", user.getName());
        System.out.printf("Age: %d%n", user.getAge());
        assertThat(user.getName(), is("Foo Bar"));
        assertThat(user.getAge(), is(25));
    }
}
