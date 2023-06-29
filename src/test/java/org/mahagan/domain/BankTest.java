package org.mahagan.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BankTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Bank}
     *   <li>{@link Bank#setBankId(long)}
     *   <li>{@link Bank#setBankName(String)}
     *   <li>{@link Bank#setCustomer(List)}
     *   <li>{@link Bank#getBankId()}
     *   <li>{@link Bank#getBankName()}
     *   <li>{@link Bank#getCustomer()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Bank actualBank = new Bank();
        actualBank.setBankId(1L);
        actualBank.setBankName("Bank Name");
        ArrayList<Customer> customer = new ArrayList<>();
        actualBank.setCustomer(customer);
        assertEquals(1L, actualBank.getBankId());
        assertEquals("Bank Name", actualBank.getBankName());
        assertSame(customer, actualBank.getCustomer());
    }
}

