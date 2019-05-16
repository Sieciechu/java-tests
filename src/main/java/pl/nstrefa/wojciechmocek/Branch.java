package pl.nstrefa.wojciechmocek;

import java.util.ArrayList;
import java.util.List;

class Branch {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    void addNewCustomer(Customer c) {

    }

    void addTransactionToCustomer(Customer customer, double transaction) {

    }
}
