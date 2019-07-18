
package pl.nstrefa.wojciechmocek;

public class Math {
    public int sumFromZeroToN(int n) {
        int sum=0;
        for (int i = 0; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }
}
