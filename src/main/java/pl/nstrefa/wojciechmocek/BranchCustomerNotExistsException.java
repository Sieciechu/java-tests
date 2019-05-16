package pl.nstrefa.wojciechmocek;

public class BranchCustomerNotExistsException extends Exception {
    private final String customerName;

    public BranchCustomerNotExistsException(Customer customer) {
        this.customerName = customer.toString();
    }
}
