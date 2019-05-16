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
            throws CustomerAccountAlreadyCreatedException {

        branchList.get(branchName).createAccount(customerName, transaction);
    }

    public List<Double> getCustomerTransactions(String branchName, String customerName) throws BranchCustomerNotExistsException {
        return branchList.get(branchName).getCustomerTransactions(customerName);
    }

    public void addTransaction(String branchName, String customerName, double transaction) throws BranchCustomerNotExistsException {
        branchList.get(branchName).addTransactionToCustomer(customerName, transaction);
    }
}
