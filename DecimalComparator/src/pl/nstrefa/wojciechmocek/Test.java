package pl.nstrefa.wojciechmocek;

/**
 * Test asserts if two double numbers are the same up to three decimal places
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Testing DecimalMathComparator:");
        runTest(new DecimalMathComparator(3));
        System.out.println("\n----------------------\n");

        System.out.println("Testing DecimalFormatComparator:");
        // This implementation does not work! Why? Because DecimalFormat.format() method rounds digits up
        // therefore the assertion at line #27 will throw the java.lang.AssertionError
        runTest(new DecimalFormatComparator());
    }

    private static void runTest(DecimalComparator comparator) {
        assert true == comparator.areSame(3.0, 3.0);
        assert true == comparator.areSame(3.123, 3.123);
        assert true == comparator.areSame(-3.123, -3.123);
        assert true == comparator.areSame(123.123, 123.1234);
        assert true == comparator.areSame(123.123, 123.12345);
        assert true == comparator.areSame(123.12345, 123.123);
        assert true == comparator.areSame(123.123456, 123.123456);

        assert true == comparator.areSame(3.1238, 3.1231);

        assert false == comparator.areSame(1.0, 2.0);
        assert false == comparator.areSame(43.12, 3.12345);
        assert false == comparator.areSame(3.12, 3.12345);
        assert false == comparator.areSame(3.124, 3.12345);
        assert false == comparator.areSame(-3.123, 3.123);
        assert false == comparator.areSame(-3.123, 3.12345);
        assert false == comparator.areSame(-3.12345, 3.123);
        System.out.println("All assertions for " + comparator.getClass().getName() + " are met");
    }
}

