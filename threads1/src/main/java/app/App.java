
package app;

public class App {
    void test() {
        System.out.println("First thread running");

        MyThread t2 = new MyThread();
        t2.start();
        System.out.println("10");


        Thread tA = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
            System.out.println("3rd thread test " + Thread.currentThread().getName());
        });
        tA.start();
        System.out.println("20");
        Thread runnable = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("anonymous runnable1 " + Thread.currentThread().getName());
                try {
                    tA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("anonymous runnable2 " + Thread.currentThread().getName());
            }
        });
        runnable.setName("New name of runnable");

        runnable.start();

        new Thread(new MyThread2()).start();
        System.out.println("30");
        System.out.println("40");

    }

    public static void main(String[] args) {
        App app = new App();
        app.test();
    }
}
