package com.jumia.test.repositories;

import com.jumia.test.entities.Customer;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author martin
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerRepositoryTest {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    @DisplayName("Test findAll Success")
    void findAllTest() throws Exception {
        List<Customer> all_customers = customerRepository.findAll();

        assertThat(all_customers.size()).isEqualTo(41);

    }
}
