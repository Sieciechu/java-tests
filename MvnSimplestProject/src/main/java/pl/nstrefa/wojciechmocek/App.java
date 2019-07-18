package pl.nstrefa.wojciechmocek;
import org.apache.commons.math3.complex.Complex; // an external library;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        double c1Im = scanner.nextDouble();
        double c1Re = scanner.nextDouble();
        double c2Im = scanner.nextDouble();
        double c2Re = scanner.nextDouble();

        Complex c1 = new Complex(c1Im, c1Re);
        Complex c2 = new Complex(c2Im, c2Re);
        Complex result = c1.add(c2);

        System.out.println(result);
    }
}
