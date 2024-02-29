package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Customer savingCustomer(int id)
    {
        return customerRepository.findById(id).orElse(null);
    }
    public List<Customer> getCustomer()
    {
        return customerRepository.findAll();
    }
    
}
