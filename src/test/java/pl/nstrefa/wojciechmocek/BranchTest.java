package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    void addNewCustomerShouldAddHimToCustomerList() {

        // given
        Branch branch = new Branch();
        assertEquals(0, branch.getCustomers().size());

        // when
        branch.addNewCustomer(new Customer("John"));

        // then
        assertEquals(1, branch.getCustomers().size());
    }
}