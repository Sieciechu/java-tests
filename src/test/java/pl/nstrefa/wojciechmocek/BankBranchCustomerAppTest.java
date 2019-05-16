package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankBranchCustomerAppTest {

    @Test
    public void testFunResturnsTrue() {
        var app = new BankBranchCustomerApp();
        assertTrue(app.fun());
    }
}
