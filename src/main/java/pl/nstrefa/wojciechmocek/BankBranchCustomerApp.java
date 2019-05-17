package pl.nstrefa.wojciechmocek;

import pl.nstrefa.wojciechmocek.bank.Bank;
import pl.nstrefa.wojciechmocek.bank.BankFactory;
import pl.nstrefa.wojciechmocek.bank.CustomerNotExistsException;
import pl.nstrefa.wojciechmocek.bank.CustomerAccountAlreadyCreatedException;

public class BankBranchCustomerApp {
    public static void main(String[] args) {

        Bank bank = new BankFactory().make();

        String branchName = args[0];
        bank.createBranch(branchName);

        String customer = args[1];

        double[] transactions = new double[args.length - 2];
        for (int i = 0, argIndex = 2; argIndex < args.length; ++i, ++argIndex) {
            transactions[i] = Double.parseDouble(args[argIndex]);
        }

        try {
            bank.createAccount(branchName, customer, transactions[0]);
            for (int i = 1; i < transactions.length; ++i) {
                bank.addTransaction(branchName, customer, transactions[i]);
            }

            System.out.printf(
                "Customer %s's transactions are: %s\n",
                customer,
                bank.getCustomerTransactions(branchName, customer)
            );
        } catch (CustomerAccountAlreadyCreatedException| CustomerNotExistsException e) {
            e.printStackTrace();
        }
    }
}
