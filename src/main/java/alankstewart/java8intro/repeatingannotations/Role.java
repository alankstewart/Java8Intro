package alankstewart.java8intro.repeatingannotations;

import java.lang.annotation.Repeatable;

/**
 * Created by alanstewart on 15/11/2015.
 */
@Repeatable(Roles.class)
public @interface Role {

    String name() default "User";
}
