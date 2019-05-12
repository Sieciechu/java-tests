package pl.nstrefa.wojciechmocek;

class DigitSum {
    public int sum(int number) {

        if (number < 10 && number > -10) {
            return number;
        }

        int digitSum = 0;
        for (int digit, divider = (number>=0 ? 10 : -10); number != 0; ) {
            digit = number % divider;
            digitSum += digit;
            number /= 10;
        }

        return digitSum;

    }
}
