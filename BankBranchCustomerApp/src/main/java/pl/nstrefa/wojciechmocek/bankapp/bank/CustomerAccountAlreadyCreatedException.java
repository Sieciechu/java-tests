package pl.nstrefa.wojciechmocek.bankapp.bank;

public class CustomerAccountAlreadyCreatedException extends Exception {
    private final String customerName;

    CustomerAccountAlreadyCreatedException(Customer customer) {
        this.customerName = customer.getName();
    }
}
