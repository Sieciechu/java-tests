package app;

public class MyThread2 implements java.lang.Runnable {
    @Override
    public void run() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
