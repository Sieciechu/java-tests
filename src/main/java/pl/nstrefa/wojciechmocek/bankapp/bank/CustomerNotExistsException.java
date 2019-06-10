package pl.nstrefa.wojciechmocek.bankapp.bank;

public class CustomerNotExistsException extends Exception {
    private final String customerName;

    CustomerNotExistsException(Customer customer) {
        this.customerName = customer.getName();
    }
}
