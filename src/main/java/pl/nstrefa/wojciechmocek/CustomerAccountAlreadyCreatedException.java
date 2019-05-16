package pl.nstrefa.wojciechmocek;

public class CustomerAccountAlreadyCreatedException extends Exception {
    private final String customerName;

    public CustomerAccountAlreadyCreatedException(Customer customer) {
        this.customerName = customer.toString();
    }
}
