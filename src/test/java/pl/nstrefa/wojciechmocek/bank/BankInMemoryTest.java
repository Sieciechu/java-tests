package pl.nstrefa.wojciechmocek.bank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankInMemoryTest {
    @Test
    void whenCreateBranchThenItIsCreated() {

        // given
        BankInMemory bank = new BankInMemory();
        assertEquals(0, bank.getBranchList().size());

        // when
        bank.createBranch("Some branch name");

        // then
        assertEquals(1, bank.getBranchList().size());
        assertEquals("Some branch name", bank.getBranchList().get(0).getName());

    }

    @Test
    void whenCreateNewAccountThenItIsCreated() throws CustomerAccountAlreadyCreatedException, CustomerNotExistsException {
        // given
        BankInMemory bank = new BankInMemory();
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
        BankInMemory bank = new BankInMemory();
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
            throws CustomerAccountAlreadyCreatedException, CustomerNotExistsException {

        // given
        BankInMemory bank = new BankInMemory();
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
        BankInMemory bank = new BankInMemory();
        bank.createBranch("PL");
        bank.createAccount("PL", "John", 123.16);

        // when-then
        assertThrows(
            CustomerNotExistsException.class,
            () -> bank.addTransaction("PL", "Max", 11.0)
        );
    }

    @Test
    void itShouldBeNotPossibleToCreateAccountForNotExistingBranch() {
        fail();
    }

    @Test
    void itShoulBeNotPossibleToAddTransactionForNotExistingBranch() {
        fail();
    }


}