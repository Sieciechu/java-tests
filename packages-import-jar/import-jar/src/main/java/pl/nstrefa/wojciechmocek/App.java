/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pl.nstrefa.wojciechmocek;

public class App {

    public void sum(int n) {
        Math m = new Math();
        System.out.println(m.sumFromZeroToN(n));
    }

    public static void main(String[] args) {
        new App().sum(5);
    }
}
