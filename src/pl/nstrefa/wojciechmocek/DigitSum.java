package pl.nstrefa.wojciechmocek;

class DigitSum {
    public int sum(int number) {

        if (number < 10 && number > -10) {
            return number;
        }

        int sum = 0;
        for (int remainder = 1, divider = (number>=0 ? 10 : -10); remainder != 0; ) {
            remainder = number % divider;
            sum += remainder;
            number /= 10;
        }

        return sum;

    }
}
