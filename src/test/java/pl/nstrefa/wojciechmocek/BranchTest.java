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
}