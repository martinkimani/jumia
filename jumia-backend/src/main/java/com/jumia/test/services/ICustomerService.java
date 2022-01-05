package com.jumia.test.services;

import com.jumia.test.entities.Customer;
import java.util.List;

/**
 *
 * @author martin
 */
public interface ICustomerService {
    public List<Customer> getCustomers(String country,Boolean valid);
}
