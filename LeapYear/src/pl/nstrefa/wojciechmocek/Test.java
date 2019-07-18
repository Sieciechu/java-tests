package pl.nstrefa.wojciechmocek;

/**
 * Test asserts if given years are leap
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Testing LeapYear:");

        LeapYear leapYear = new LeapYear();

        assert true == leapYear.isLeap(1600);
        assert true == leapYear.isLeap(2000);
        assert true == leapYear.isLeap(2016);
        assert true == leapYear.isLeap(2020);
        assert true == leapYear.isLeap(2024);
        assert true == leapYear.isLeap(2028);
        assert true == leapYear.isLeap(2400);

        assert false == leapYear.isLeap(1700);
        assert false == leapYear.isLeap(1800);
        assert false == leapYear.isLeap(1900);
        assert false == leapYear.isLeap(2007);
        assert false == leapYear.isLeap(2100);
        assert false == leapYear.isLeap(2200);
        assert false == leapYear.isLeap(2300);
        assert false == leapYear.isLeap(2500);
        assert false == leapYear.isLeap(2600);

        System.out.println("All assertions for " + leapYear.getClass().getName() + " are met");

        System.out.println("\n----------------------\n");

    }

}
