package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void itShouldBeImpossibleToCreateCustomerWithoutName() {
        assertThrows(
            NullPointerException.class,
            () -> new Customer(null)
        );
    }

    @Test
    void whenAddTransactionThenCustomerHasNewTransaction() {

        // given
        var customer = new Customer("John");
        assertEquals(0, customer.getTransactions().size());

        // when
        customer.addTransaction(1.0);

        // then
        assertEquals(1, customer.getTransactions().size());
    }

    @Test
    void getTransactionsReturnsCopyToAvoidOutsideChanges() {
        // given
        var customer = new Customer("John");
        customer.addTransaction(1.0);
        customer.addTransaction(2.0);

        // when
        List<Double> customerTransactionsCopy = customer.getTransactions();
        customerTransactionsCopy.add(3.0);

        // then
        assertNotSame(customer.getTransactions(), customerTransactionsCopy);
        assertNotEquals(customer.getTransactions().size(), customerTransactionsCopy.size());
        assertEquals(2, customer.getTransactions().size());
        assertEquals(3, customerTransactionsCopy.size());
    }
}
