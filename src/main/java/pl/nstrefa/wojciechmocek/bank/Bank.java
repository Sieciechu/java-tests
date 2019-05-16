package pl.nstrefa.wojciechmocek.bank;

import java.util.List;

public interface Bank {
    void createBranch(String branchName);
    void createAccount(String branchName, String customerName, double transaction) throws CustomerAccountAlreadyCreatedException;
    List<Double> getCustomerTransactions(String branchName, String customerName) throws BranchCustomerNotExistsException;
    void addTransaction(String branchName, String customerName, double transaction) throws BranchCustomerNotExistsException;
}
