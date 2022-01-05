package com.jumia.test.repositories;

import com.jumia.test.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martin
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
