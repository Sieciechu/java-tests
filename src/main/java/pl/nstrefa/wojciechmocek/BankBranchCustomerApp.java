package pl.nstrefa.wojciechmocek;

import pl.nstrefa.wojciechmocek.bank.Bank;
import pl.nstrefa.wojciechmocek.bank.BankFactory;
import pl.nstrefa.wojciechmocek.bank.Exception;
import pl.nstrefa.wojciechmocek.controller.CliController;

public class BankBranchCustomerApp {

    public static void main(String[] args) {
        Bank bank = new BankFactory().make();

        feedWithData(bank);

        new CliController(bank).run();
    }

    private static void feedWithData(Bank bank) {
        try {
            String branchName = "pl";
            bank.createBranch(branchName);
            bank.createAccount(branchName, "Jan Kowalski", 12.6);
            bank.createAccount(branchName, "Anna Nowak", 3232.0);
            bank.createAccount(branchName, "Piotr Dąbrowski", 1000.0);
            bank.addTransaction(branchName, "Piotr Dąbrowski", 120.0);
            bank.addTransaction(branchName, "Piotr Dąbrowski", 120.0);
            bank.addTransaction(branchName, "Piotr Dąbrowski", 120.0);
            bank.addTransaction(branchName, "Jan Kowalski", 1000.0);
            bank.addTransaction(branchName, "Jan Kowalski", 1100.0);

            branchName = "uk";
            bank.createBranch(branchName);
            bank.createAccount(branchName, "John Smith", 100.0);
            bank.createAccount(branchName, "Max Bridge", 100.0);
            bank.addTransaction(branchName, "John Smith", 20.0);
            bank.addTransaction(branchName, "John Smith", 20.0);
            bank.addTransaction(branchName, "Max Bridge", 2000.0);
            bank.addTransaction(branchName, "Max Bridge", 2100.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
