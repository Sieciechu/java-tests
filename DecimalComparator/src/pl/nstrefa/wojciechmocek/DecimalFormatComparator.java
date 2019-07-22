package pl.nstrefa.wojciechmocek;

import java.text.DecimalFormat;

/**
 * Class returns boolean indicating if two double numbers are the same up to three decimal places
 */
public class DecimalFormatComparator implements DecimalComparator {

    public boolean areSame(double a, double b) {
        var decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(3);
        decimalFormat.setMaximumFractionDigits(3);

        return Double.parseDouble(decimalFormat.format(a)) == Double.parseDouble(decimalFormat.format(b));
    }
}

