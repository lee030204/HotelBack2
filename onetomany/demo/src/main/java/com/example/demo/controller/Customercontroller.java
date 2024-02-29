package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class Customercontroller 
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/get/{id}")
    public Customer customer(@PathVariable int id)
    {
        return customerService.savingCustomer(id);
    }

    @GetMapping("/get/custom")
    public List<Customer> getCustomer()
    {
        return customerService.getCustomer();
    }
    
}
