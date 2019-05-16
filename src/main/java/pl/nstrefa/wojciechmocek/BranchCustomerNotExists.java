package pl.nstrefa.wojciechmocek;

public class BranchCustomerNotExists extends Exception {
    public BranchCustomerNotExists(String message) {
        super(message);
    }
}
