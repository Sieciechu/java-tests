package pl.nstrefa.wojciechmocek.bank;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     *
     * @return Unmodifiable list
     */
    List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    void createAccount(String customerName, double transaction) throws CustomerAccountAlreadyCreatedException {
        Customer branchCustomer = new Customer(customerName);
        branchCustomer.addTransaction(transaction);

        if (customers.contains(branchCustomer)) {
            throw new CustomerAccountAlreadyCreatedException(branchCustomer);
        }

        customers.add(branchCustomer);
    }

    void addTransactionToCustomer(String customerName, double transaction) throws CustomerNotExistsException {
        getCustomer(customerName).addTransaction(transaction);
    }

    private Customer getCustomer(String customerName) throws CustomerNotExistsException {
        Customer customer = new Customer(customerName);
        int index = customers.indexOf(customer);

        if (-1 == index) {
            throw new CustomerNotExistsException(customer);
        }

        return customers.get(index);
    }

    /**
     *
     * @param customerName
     * @return Unmodifiable list of transactions
     * @throws CustomerNotExistsException
     */
    List<Double> getCustomerTransactions(String customerName) throws CustomerNotExistsException {
        return getCustomer(customerName).getTransactions();
    }
}
