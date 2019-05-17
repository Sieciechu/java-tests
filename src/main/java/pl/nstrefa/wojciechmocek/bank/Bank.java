package pl.nstrefa.wojciechmocek.bank;

import java.util.List;

public interface Bank {
    void createBranch(String branchName);

    void createAccount(String branchName, String customerName, double transaction) throws CustomerAccountAlreadyCreatedException, BranchNotExistsException;

    List<Double> getCustomerTransactions(String branchName, String customerName) throws CustomerNotExistsException, BranchNotExistsException;

    void addTransaction(String branchName, String customerName, double transaction) throws CustomerNotExistsException, BranchNotExistsException;
}
