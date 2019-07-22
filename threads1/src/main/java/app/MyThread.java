package app;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Another thread running");
    }
}
