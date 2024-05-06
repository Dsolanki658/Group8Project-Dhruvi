package edu.depaul.cdm.se452.Group8Project.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.Group8Project.customer.CustomerRepository;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository repository;

    public Account getChecking(long id){
        return repository.findCA(id);
    }

    public Account getSaving(long id){
        return repository.findSA(id);
    }

    public void save(Customer customer){
        repository.save(customer);
    }

    public void delete(long id){
        repository.delete(id);
    }
}
