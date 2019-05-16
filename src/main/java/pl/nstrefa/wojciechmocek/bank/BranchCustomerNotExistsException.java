package pl.nstrefa.wojciechmocek.bank;

public class BranchCustomerNotExistsException extends Exception {
    private final String customerName;

    BranchCustomerNotExistsException(Customer customer) {
        this.customerName = customer.toString();
    }
}
