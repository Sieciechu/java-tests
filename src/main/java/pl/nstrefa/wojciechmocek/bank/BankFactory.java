package pl.nstrefa.wojciechmocek.bank;

public class BankFactory {
    public Bank make() {
        return new BankInMemory();
    }
}
