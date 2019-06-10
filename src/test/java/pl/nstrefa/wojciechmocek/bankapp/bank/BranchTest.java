package pl.nstrefa.wojciechmocek.bankapp.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BranchTest {

    @Test
    void createAccountShouldAddHimToCustomerList() throws CustomerAccountAlreadyCreatedException {

        // given
        Branch branch = new Branch("some name");
        assertEquals(0, branch.getCustomers().size());

        // when
        branch.createAccount("John", 2.1);

        // then
        assertEquals(1, branch.getCustomers().size());
    }

    @Test
    void itShouldNotBePossibleToCreateNewAccountsForSameCustomer() throws CustomerAccountAlreadyCreatedException {

        // given
        Branch branch = new Branch("some name");
        assertEquals(0, branch.getCustomers().size());

        // when-then
        assertThrows(
                CustomerAccountAlreadyCreatedException.class,
                () -> {
                    branch.createAccount("John", 1.1);
                    branch.createAccount("John", 1.1);
                    branch.createAccount("John", 1.1);
                }
        );
    }

    @Test
    void whenAddTransactionsToCustomerThenCustomerHasNewTransactions()
            throws CustomerNotExistsException, CustomerAccountAlreadyCreatedException {

        // given
        Branch branch = new Branch("some name");
        branch.createAccount("John", 1.1);

        assertEquals(1, branch.getCustomerTransactions("John").size());

        // when
        branch.addTransactionToCustomer("John", 3.1);
        branch.addTransactionToCustomer("John", 3.1);

        // then
        assertEquals(3, branch.getCustomerTransactions("John").size());
    }

    @Test
    void itShouldBeImpossibleToAddTransactionToCustomerNotAssignedToBranch()
            throws CustomerAccountAlreadyCreatedException, CustomerNotExistsException {

        // given
        Branch branch = new Branch("some name");
        branch.createAccount("John", 1.1);

        assertEquals(1, branch.getCustomerTransactions("John").size());

        // when-then
        assertThrows(
            CustomerNotExistsException.class,
            () -> branch.addTransactionToCustomer("Some other customer", 3.1)
        );
    }
}
