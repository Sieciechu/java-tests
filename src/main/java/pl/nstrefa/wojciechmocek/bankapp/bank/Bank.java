package pl.nstrefa.wojciechmocek.bankapp.bank;

import java.util.List;

public interface Bank {
    void createBranch(String branchName);

    void createAccount(String branchName, String customerName, double transaction) throws Exception;

    List<Double> getCustomerTransactions(String branchName, String customerName) throws Exception;

    void addTransaction(String branchName, String customerName, double transaction) throws Exception;

    String[] getBranches();

    List<Customer> getBranchCustomerList(String branchName) throws Exception;
}
