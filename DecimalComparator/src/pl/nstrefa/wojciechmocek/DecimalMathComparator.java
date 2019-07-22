package pl.nstrefa.wojciechmocek;

/**
 * Class returns boolean indicating if two double numbers are the same up to N decimal places
 */
public class DecimalMathComparator implements DecimalComparator {
    private final int FRACTION_DIGITS_TO_COMPARE;

    DecimalMathComparator(int FRACTION_DIGITS_TO_COMPARE) {
        if (FRACTION_DIGITS_TO_COMPARE < 0) {
            throw new IllegalArgumentException();
        }

        this.FRACTION_DIGITS_TO_COMPARE = FRACTION_DIGITS_TO_COMPARE;
    }

    public boolean areSame(double a, double b) {
        int integerPartA = (int)a;
        int integerPartB = (int)b;

        if(integerPartA != integerPartB) {
            return false;
        }
        if (0 == FRACTION_DIGITS_TO_COMPARE) {
            return true;
        }

        int fractionPartA = Double.valueOf((a - integerPartA)*Math.pow(10, FRACTION_DIGITS_TO_COMPARE)).intValue();
        int fractionPartB = Double.valueOf((b - integerPartA)*Math.pow(10, FRACTION_DIGITS_TO_COMPARE)).intValue();
        return fractionPartA == fractionPartB;

    }
}

