package com.jumia.test.services.impl;

import com.jumia.test.entities.Country;
import com.jumia.test.entities.Customer;
import com.jumia.test.repositories.CustomerRepository;
import com.jumia.test.services.ICustomerService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author martin
 */
@Service
public class CustomerServiceImpl implements ICustomerService{
    
    private final CustomerRepository customerRepository;
        
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers( String country,Boolean valid) {
        List<Customer> all_customers = customerRepository.findAll();
        Comparator <Customer> sortedCustomers = Comparator.comparing(Customer::getCountry_code)
                .thenComparing(Customer::isValid,Comparator.reverseOrder())
                .thenComparing(Customer::getPhone);
        Predicate<Customer> filter_countries = customer -> country == null || customer.getCountry().equalsIgnoreCase(country);
        Predicate<Customer> filter_state = customer -> valid == null || customer.isValid() == valid;
        return all_customers.stream()
                .map(customer -> validateCustomerPhoneNumber(customer))
                .filter(filter_countries)
                .filter(filter_state)
                .sorted(sortedCustomers)
                .collect(Collectors.toList());
    }
    
    private Customer validateCustomerPhoneNumber(Customer customer) {
        List<Country> all_countries = getCountries();
        for (Country all_country : all_countries) {
            var regex = all_country.getCountry_regex();
            var code_regex  = regex.split("\\?")[0];
            var phone_sub = customer.getPhone().substring(0, 6);
            if (Pattern.matches(code_regex, phone_sub)) {
                var country = all_country.getCountry();
                var isValid = Pattern.matches(regex, customer.getPhone());
                customer = new Customer(customer.getId(), customer.getName(), customer.getPhone(), country, isValid, all_country.getCountry_code());
                break;
            }
        }
        return customer;
    }
    
    private List<Country> getCountries() {
        List<Country> all_countries = new ArrayList<>();
        all_countries.add(new Country("Cameroon", "+237", "\\(237\\)\\ ?[2368]\\d{7,8}$"));
        all_countries.add(new Country("Ethiopia", "+251", "\\(251\\)\\ ?[1-59]\\d{8}$"));
        all_countries.add(new Country("Morocco", "+212", "\\(212\\)\\ ?[5-9]\\d{8}$"));
        all_countries.add(new Country("Mozambique", "+258", "\\(258\\)\\ ?[28]\\d{7,8}$"));
        all_countries.add(new Country("Uganda", "+256", "\\(256\\)\\ ?\\d{9}$"));
        return all_countries;
    }
    
}
