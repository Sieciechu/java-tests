package pl.nstrefa.wojciechmocek.bank;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


final class Customer {

    private String name;
    private List<Double> transactions;

    Customer(@NonNull String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    List<Double> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
