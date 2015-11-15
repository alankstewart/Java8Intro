package alankstewart.java8intro.lambda;

/**
 * Example of a functional interface, i.e., an interface with a single method only.
 */
@FunctionalInterface
public interface MathOperation {

    int operation(int x, int y);
}
