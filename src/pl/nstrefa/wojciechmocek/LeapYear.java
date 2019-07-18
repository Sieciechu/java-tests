package pl.nstrefa.wojciechmocek;

class LeapYear {
    public boolean isLeap(int year) {

        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}