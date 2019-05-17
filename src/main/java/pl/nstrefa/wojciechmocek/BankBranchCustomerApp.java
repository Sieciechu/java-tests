package pl.nstrefa.wojciechmocek;

import pl.nstrefa.wojciechmocek.bank.Bank;
import pl.nstrefa.wojciechmocek.bank.BankFactory;
import pl.nstrefa.wojciechmocek.controller.CliController;

public class BankBranchCustomerApp {

    public static void main(String[] args) {
        Bank bank = new BankFactory().make();
        new CliController(bank).run();
    }
}
