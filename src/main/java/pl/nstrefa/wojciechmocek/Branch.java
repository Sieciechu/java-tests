package pl.nstrefa.wojciechmocek;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

class Branch {
    private final String name;
    private List<Customer> customers = new ArrayList<>();

    Branch(@NonNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    void createAccount(String customerName, double transaction) throws CustomerAccountAlreadyCreatedException {
        Customer branchCustomer = new Customer(customerName);
        branchCustomer.addTransaction(transaction);

        if (customers.contains(branchCustomer)) {
            throw new CustomerAccountAlreadyCreatedException(branchCustomer);
        }

        customers.add(branchCustomer);
    }

    void addTransactionToCustomer(String customerName, double transaction) throws BranchCustomerNotExistsException {
        getCustomer(customerName).addTransaction(transaction);
    }

    private Customer getCustomer(String customerName) throws BranchCustomerNotExistsException {
        Customer customer = new Customer(customerName);
        int index = customers.indexOf(customer);

        if (-1 == index) {
            throw new BranchCustomerNotExistsException(customer);
        }

        return customers.get(index);
    }

    List<Double> getCustomerTransactions(String customerName) throws BranchCustomerNotExistsException {
        return getCustomer(customerName).getTransactions();
    }
}
