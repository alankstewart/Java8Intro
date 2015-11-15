package alankstewart.java8intro.methodref;

/**
 * Created by alanstewart on 15/11/2015.
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();

        new Thread(MethodReferenceDemo::doWork).start();

        new Thread(() -> doWork()).start();
    }

    static void doWork() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d%n", name, i);
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
            }
        }
    }
}