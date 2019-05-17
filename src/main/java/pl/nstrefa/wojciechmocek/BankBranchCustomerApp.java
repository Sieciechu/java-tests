package pl.nstrefa.wojciechmocek;

import pl.nstrefa.wojciechmocek.bank.Bank;
import pl.nstrefa.wojciechmocek.bank.BankFactory;

public class BankBranchCustomerApp {

    private Controller controller;

    public BankBranchCustomerApp(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        Bank bank = new BankFactory().make();
        var app = new BankBranchCustomerApp(new CliController(bank));
        app.controller.run();
    }
}
