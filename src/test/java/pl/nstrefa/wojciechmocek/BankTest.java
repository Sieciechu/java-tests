package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void whenCreateNewAccountThenItIsCreated() {
        fail();
    }

    @Test
    void itShouldBeNotPossibleToCreateMoreThanOnceAccountForSameCustomer() {

    }

    @Test
    void whenAddTransactionToCustomerThenHeHasNewTransaction() {
        fail();
    }

    @Test
    void itShouldBeNotPossibleToAddTransactionForNonExistingCustomer() {
        fail();
    }
}