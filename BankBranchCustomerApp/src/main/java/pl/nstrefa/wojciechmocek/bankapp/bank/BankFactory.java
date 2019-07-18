package pl.nstrefa.wojciechmocek.bankapp.bank;

public class BankFactory {
    public Bank make() {
        return new BankInMemory();
    }
}
