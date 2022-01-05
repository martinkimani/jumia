package com.jumia.test.controllers;

import com.jumia.test.services.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martin
 */
@RestController
@CrossOrigin("http://localhost:4200")
public class CustomerController {
    
    private final ICustomerService customerService;
    public CustomerController(ICustomerService customerService) {
        this.customerService =  customerService;
    }
    
    @GetMapping("/customers")
    public ResponseEntity getAllCustomers(@RequestParam(value="country", required = false) String country,
            @RequestParam(value="is_valid", required = false) Boolean is_valid) {
        return new ResponseEntity(customerService.getCustomers(country, is_valid), HttpStatus.OK);
    }
}
