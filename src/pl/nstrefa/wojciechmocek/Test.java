package pl.nstrefa.wojciechmocek;

/**
 * Test asserts if given years are leap
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Testing DigitSum:");

        DigitSum digitSum = new DigitSum();

        assert 1 == digitSum.sum(1);
        assert 2 == digitSum.sum(2);
        assert 3 == digitSum.sum(21);
        assert 8 == digitSum.sum(215);
        assert 17 == digitSum.sum(2159);
        assert 0 == digitSum.sum(0);
        assert -1 == digitSum.sum(-1);
        assert -2 == digitSum.sum(-2);
        assert -3 == digitSum.sum(-21);

        System.out.println("All assertions for " + digitSum.getClass().getName() + " are met");

        System.out.println("\n----------------------\n");

    }

}
