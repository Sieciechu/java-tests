package pl.nstrefa.wojciechmocek;

/**
 * Test asserts if given years are leap
 */
public class Test {
    public static void main(String[] args) {
        testDigitSum();
        testDigitSumFirstAndLast();
        ForLoopTest.testIfForeachEvaluatesMethodEachTime();
        ForLoopTest.testIfForLoopEvaluatesMethodEachTime();
    }

    private static void testDigitSum() {
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

        System.out.println("All assertions for DigitSum are met");

        System.out.println("\n----------------------\n");
    }

    private static void testDigitSumFirstAndLast() {
        System.out.println("Testing DigitSumFirstAndLast:");

        DigitSum digitSum = new DigitSum();

        assert 1 == digitSum.sumFirstAndLast(1);
        assert 2 == digitSum.sumFirstAndLast(2);
        assert 3 == digitSum.sumFirstAndLast(21);
        assert 7 == digitSum.sumFirstAndLast(215);
        assert 11 == digitSum.sumFirstAndLast(2159);
        assert 0 == digitSum.sumFirstAndLast(0);
        assert -1 == digitSum.sumFirstAndLast(-1);
        assert -2 == digitSum.sumFirstAndLast(-2);
        assert -3 == digitSum.sumFirstAndLast(-21);
        assert -7 == digitSum.sumFirstAndLast(-215);
        assert -11 == digitSum.sumFirstAndLast(-2159);

        System.out.println("All assertions for DigitSumFirstAndLast are met");

        System.out.println("\n----------------------\n");
    }
}
