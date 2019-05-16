package pl.nstrefa.wojciechmocek;

import java.util.ArrayList;
import java.util.List;

class Branch {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    void assignCustomer(Customer c) {
        if (!customers.contains(c)) {
            customers.add(c);
        }
    }

    void addTransactionToCustomer(Customer customer, double transaction) throws BranchCustomerNotExists {
        getCustomer(customer).addTransaction(transaction);
    }

    private Customer getCustomer(Customer customer) throws BranchCustomerNotExists {
        int index = customers.indexOf(customer);

        if (-1 == index) {
            throw new BranchCustomerNotExists(customer.toString());
        }

        return customers.get(index);
    }

    Customer getCustomerData(Customer customer) throws BranchCustomerNotExists {
        return getCustomer(customer).makeCopy();
    }
}
