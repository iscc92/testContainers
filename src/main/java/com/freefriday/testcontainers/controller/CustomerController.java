package com.freefriday.testcontainers.controller;

import com.freefriday.testcontainers.model.Customer;
import com.freefriday.testcontainers.service.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/get")
    public List<Customer> getCostumers() {
        List<Customer> customers = customerDao.findAll();
        customers.forEach(c -> logger.info("Found costumer: {}", c));
        return customers;

    }
}
