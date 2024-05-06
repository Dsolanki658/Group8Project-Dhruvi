package edu.depaul.cdm.se452.Group8Project.customer;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.Group8Project.customer.CustomerRepository;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository repository;

    
}
