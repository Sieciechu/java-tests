package pl.nstrefa.wojciechmocek;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


final public class Customer {

    private String name;
    private List<Double> transactions;

    public Customer(@NonNull String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                transactions.equals(customer.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, transactions);
    }
}
