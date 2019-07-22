
package app;

public class App {
    void test() {
        System.out.println("First thread running");

        MyThread t2 = new MyThread();
        t2.start();

        System.out.println("something else");

        new Thread(() -> System.out.println("3rd thread test")).start();

    }

    public static void main(String[] args) {
        App app = new App();
        app.test();
    }
}
