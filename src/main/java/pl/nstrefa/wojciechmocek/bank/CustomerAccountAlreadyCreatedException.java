package pl.nstrefa.wojciechmocek.bank;

public class CustomerAccountAlreadyCreatedException extends Exception {
    private final String customerName;

    CustomerAccountAlreadyCreatedException(Customer customer) {
        this.customerName = customer.toString();
    }
}
