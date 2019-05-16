package pl.nstrefa.wojciechmocek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private String name;
    private List<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    public Customer(String name, List<Double> transactions) {
        this.name = name;
        this.transactions = new ArrayList<>();
        Collections.copy(this.transactions, transactions);
    }

}
