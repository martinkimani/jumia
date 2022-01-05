package com.jumia.test.services;

import com.jumia.test.entities.Customer;
import com.jumia.test.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.doReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author martin
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerServiceTest {
    
    @Autowired
    private ICustomerService customerService;
    
    @MockBean
    private CustomerRepository customerRepository;
    
    @Test
    @DisplayName("Test filter by country success")
    void filterByCountryCountTest() throws Exception {
        List<Customer> mock_customers = new ArrayList<>();
        mock_customers.add(new Customer(1, "Elizabeth Were", "(256) 704244430", null, false, null));
        mock_customers.add(new Customer(2, "Elias Makori", "(256) 714660221", null, false, null));
        mock_customers.add(new Customer(3, "Bob Kyagulanyi", "(256) 3142345678", null, false, null));
        mock_customers.add(new Customer(4, "Riyadh Mahrez", "(212) 633963130", null, false, null));
        doReturn(mock_customers).when(customerRepository).findAll();
        
        List<Customer> uganda_customers = customerService.getCustomers("Uganda", null);

        assertThat(uganda_customers.size()).isEqualTo(3);

    }
    
    @Test
    @DisplayName("Test only Uganda customers were returned success")
    void filterByCountryTest() throws Exception {
        List<Customer> mock_customers = new ArrayList<>();
        mock_customers.add(new Customer(1, "Elizabeth Were", "(256) 704244430", null, false, null));
        mock_customers.add(new Customer(2, "Elias Makori", "(256) 714660221", null, false, null));
        mock_customers.add(new Customer(3, "Bob Kyagulanyi", "(256) 3142345678", null, false, null));
        mock_customers.add(new Customer(4, "Riyadh Mahrez", "(212) 633963130", null, false, null));
        doReturn(mock_customers).when(customerRepository).findAll();
        
        List<Customer> uganda_customers = customerService.getCustomers("Uganda", null);
        Predicate<Customer> ug_only = customer -> customer.getCountry().equals("Uganda");
        boolean all_uganda_matches = uganda_customers.stream().allMatch(ug_only);

        assertThat(all_uganda_matches);

    }
    
    @Test
    @DisplayName("Test filter by state success")
    void filterByStateCountTest() throws Exception {
        List<Customer> mock_customers = new ArrayList<>();
        mock_customers.add(new Customer(1, "Elizabeth Were", "(256) 704244430", null, false, null));
        mock_customers.add(new Customer(2, "Elias Makori", "(256) 714660221", null, false, null));
        mock_customers.add(new Customer(3, "Bob Kyagulanyi", "(256) 3142345678", null, false, null));
        mock_customers.add(new Customer(4, "Riyadh Mahrez", "(212) 633963130", null, false, null));
        doReturn(mock_customers).when(customerRepository).findAll();
        
        List<Customer> uganda_customers = customerService.getCustomers(null, true);

        assertThat(uganda_customers.size()).isEqualTo(3);

    }
    
    @Test
    @DisplayName("Test only customers with valid phone numbers were returned success")
    void filterByStateTest() throws Exception {
        List<Customer> mock_customers = new ArrayList<>();
        mock_customers.add(new Customer(1, "Elizabeth Were", "(256) 704244430", null, false, null));
        mock_customers.add(new Customer(2, "Elias Makori", "(256) 714660221", null, false, null));
        mock_customers.add(new Customer(3, "Bob Kyagulanyi", "(256) 3142345678", null, false, null));
        mock_customers.add(new Customer(4, "Riyadh Mahrez", "(212) 633963130", null, false, null));
        doReturn(mock_customers).when(customerRepository).findAll();
        
        List<Customer> valid_customers = customerService.getCustomers(null, true);
        Predicate<Customer> valid_only = customer -> customer.isValid() == true;
        boolean all_valid_matches = valid_customers.stream().allMatch(valid_only);

        assertThat(all_valid_matches);

    }
    
    @Test
    @DisplayName("Test only customers from Uganda and with valid phone numbers were returned success")
    void filterByCountryAndStateTest() throws Exception {
        List<Customer> mock_customers = new ArrayList<>();
        mock_customers.add(new Customer(1, "Elizabeth Were", "(256) 704244430", null, false, null));
        mock_customers.add(new Customer(2, "Elias Makori", "(256) 714660221", null, false, null));
        mock_customers.add(new Customer(3, "Bob Kyagulanyi", "(256) 3142345678", null, false, null));
        mock_customers.add(new Customer(4, "Riyadh Mahrez", "(212) 633963130", null, false, null));
        doReturn(mock_customers).when(customerRepository).findAll();
        
        List<Customer> uganda_customers = customerService.getCustomers("uganda", true);
        Predicate<Customer> ug_valid_only = customer -> customer.getCountry().equals("Uganda") && customer.isValid() == true;
        boolean all_uganda_matches = uganda_customers.stream().allMatch(ug_valid_only);

        assertThat(all_uganda_matches);
        assertThat(uganda_customers.size()).isEqualTo(2);

    }
}
