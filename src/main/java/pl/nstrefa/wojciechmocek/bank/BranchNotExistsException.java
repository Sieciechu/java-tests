package pl.nstrefa.wojciechmocek.bank;

public class BranchNotExistsException extends Exception {
    public BranchNotExistsException(String message) {
        super(message);
    }
}
