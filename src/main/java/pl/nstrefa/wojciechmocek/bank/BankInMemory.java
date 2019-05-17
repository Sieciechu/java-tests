package pl.nstrefa.wojciechmocek.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BankInMemory implements Bank {
    private Map<String, Branch> branchList = new HashMap<>();

    public void createBranch(String branchName) {
        branchList.put(branchName, new Branch(branchName));
    }

    List<Branch> getBranchList() {
        return new ArrayList<>(branchList.values());
    }

    public void createAccount(String branchName, String customerName, double transaction)
        throws CustomerAccountAlreadyCreatedException, BranchNotExistsException {

        getBranch(branchName).createAccount(customerName, transaction);
    }

    public List<Double> getCustomerTransactions(String branchName, String customerName) throws CustomerNotExistsException, BranchNotExistsException {
        return getBranch(branchName).getCustomerTransactions(customerName);
    }

    public void addTransaction(String branchName, String customerName, double transaction) throws CustomerNotExistsException, BranchNotExistsException {
        getBranch(branchName).addTransactionToCustomer(customerName, transaction);
    }

    private Branch getBranch(String branchName) throws BranchNotExistsException {
        if (!branchList.containsKey(branchName)) {
            throw new BranchNotExistsException("Branch " + branchName + " does not exist");
        }

        return branchList.get(branchName);
    }
}
