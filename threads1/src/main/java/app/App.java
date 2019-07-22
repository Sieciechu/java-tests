
package app;

public class App {
    void test() {
        System.out.println("First thread running");

        MyThread t2 = new MyThread();
        t2.start();
        System.out.println("10");


        new Thread(() -> System.out.println("3rd thread test")).start();
        System.out.println("20");

        new Thread(new MyThread2()).start();
        System.out.println("30");

        Thread runnable = new Thread(new java.lang.Runnable(){
            @Override
            public void run(){
                System.out.println("anonymous runnable");
            }
        });

        runnable.start();
        System.out.println("40");

    }

    public static void main(String[] args) {
        App app = new App();
        app.test();
    }
}
