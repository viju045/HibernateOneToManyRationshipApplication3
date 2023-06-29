package org.mahagan.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Customer}
     *   <li>{@link Customer#setCustomerFirstName(String)}
     *   <li>{@link Customer#setCustomerId(long)}
     *   <li>{@link Customer#setCustomerLastName(String)}
     *   <li>{@link Customer#setCustomerMobile(String)}
     *   <li>{@link Customer#getCustomerFirstName()}
     *   <li>{@link Customer#getCustomerId()}
     *   <li>{@link Customer#getCustomerLastName()}
     *   <li>{@link Customer#getCustomerMobile()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setCustomerFirstName("Jane");
        actualCustomer.setCustomerId(1L);
        actualCustomer.setCustomerLastName("Doe");
        actualCustomer.setCustomerMobile("Customer Mobile");
        assertEquals("Jane", actualCustomer.getCustomerFirstName());
        assertEquals(1L, actualCustomer.getCustomerId());
        assertEquals("Doe", actualCustomer.getCustomerLastName());
        assertEquals("Customer Mobile", actualCustomer.getCustomerMobile());
    }
}

