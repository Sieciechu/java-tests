package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    void assignCustomerShouldAddHimToCustomerList() {

        // given
        Branch branch = new Branch();
        assertEquals(0, branch.getCustomers().size());

        // when
        branch.assignCustomer(new Customer("John"));

        // then
        assertEquals(1, branch.getCustomers().size());
    }

    @Test
    void assignCustomerMultipleTimesShouldAddHimToCustomerListJustOnce() {

        // given
        Branch branch = new Branch();
        assertEquals(0, branch.getCustomers().size());

        // when
        branch.assignCustomer(new Customer("John"));
        branch.assignCustomer(new Customer("John"));
        branch.assignCustomer(new Customer("John"));

        // then
        assertEquals(1, branch.getCustomers().size());
    }

    @Test
    void whenAddTransactionsToCustomerThenCustomerHasNewTransactions() throws BranchCustomerNotExists {

        // given
        Branch branch = new Branch();
        Customer customer = new Customer("John");
        branch.assignCustomer(customer);

        assertEquals(0, customer.getTransactions().size());

        // when
        branch.addTransactionToCustomer(customer, 3.1);
        branch.addTransactionToCustomer(customer, 3.1);

        // then
        branch.getCustomerData(customer).getTransactions();
        assertEquals(2, customer.getTransactions().size());
    }

    @Test
    void itShouldBeImpossibleToAddTransactionToCustomerNotAssignedToBranch() {
        // given
        Branch branch = new Branch();
        Customer customer = new Customer("John");
        branch.assignCustomer(customer);

        assertEquals(0, customer.getTransactions().size());

        // when-then
        assertThrows(
            BranchCustomerNotExists.class,
            () -> branch.addTransactionToCustomer(new Customer("Some other customer"), 3.1)
        );
    }
}
