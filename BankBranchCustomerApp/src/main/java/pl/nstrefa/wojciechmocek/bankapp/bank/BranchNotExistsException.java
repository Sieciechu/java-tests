package pl.nstrefa.wojciechmocek.bankapp.bank;

public class BranchNotExistsException extends Exception {
    public BranchNotExistsException(String message) {
        super(message);
    }
}
