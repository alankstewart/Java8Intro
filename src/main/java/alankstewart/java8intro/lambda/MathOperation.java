package alankstewart.java8intro.lambda;

/**
 * Example of a functional interface, i.e., an interface with a single method only.
 * <p>
 * The @FunctionalInterface annotation is optional but if present, the compiler will generate
 * an error if another method is added.
 * </p>
 */
@FunctionalInterface
public interface MathOperation {

    int operation(int x, int y);
}
