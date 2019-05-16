package pl.nstrefa.wojciechmocek.bank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankTest {
    @Test
    void whenCreateBranchThenItIsCreated() {

        // given
        Bank bank = new Bank();
        assertEquals(0, bank.getBranchList().size());

        // when
        bank.createBranch("Some branch name");

        // then
        assertEquals(1, bank.getBranchList().size());
        assertEquals("Some branch name", bank.getBranchList().get(0).getName());

    }

    @Test
    void whenCreateNewAccountThenItIsCreated() throws CustomerAccountAlreadyCreatedException, BranchCustomerNotExistsException {
        // given
        Bank bank = new Bank();
        bank.createBranch("PL");

        // when
        bank.createAccount("PL", "John", 123.16);

        // then
        List<Double> customerTransactions = bank.getCustomerTransactions("PL", "John");
        assertEquals(123.16, customerTransactions.get(0));
    }

    @Test
    void itShouldBeNotPossibleToCreateAccountMoreThanOnceForSameCustomer() {
        // given
        Bank bank = new Bank();
        bank.createBranch("PL");

        // when-then
        assertThrows(
            CustomerAccountAlreadyCreatedException.class,
            () -> {
                bank.createAccount("PL", "John", 123.16);
                bank.createAccount("PL", "John", 123.16);
                bank.createAccount("PL", "John", 123.16);
            }
        );
    }

    @Test
    void whenAddTransactionToCustomerThenHeHasNewTransaction()
            throws CustomerAccountAlreadyCreatedException, BranchCustomerNotExistsException {

        // given
        Bank bank = new Bank();
        bank.createBranch("PL");
        bank.createAccount("PL", "John", 123.16);
        assertEquals(1, bank.getCustomerTransactions("PL", "John").size());

        // when
        bank.addTransaction("PL", "John", 12.0);

        // then
        List<Double> customerTransactions = bank.getCustomerTransactions("PL", "John");
        assertEquals(2, customerTransactions.size());
        assertEquals(123.16, customerTransactions.get(0));
        assertEquals(12.0, customerTransactions.get(1));
    }

    @Test
    void itShouldBeNotPossibleToAddTransactionForNonExistingCustomer() throws CustomerAccountAlreadyCreatedException {
        // given
        Bank bank = new Bank();
        bank.createBranch("PL");
        bank.createAccount("PL", "John", 123.16);

        // when-then
        assertThrows(
            BranchCustomerNotExistsException.class,
            () -> bank.addTransaction("PL", "Max", 11.0)
        );
    }
}