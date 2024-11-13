package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean loginCustomer(String login, String password) {
        return customerRepository.isCustomerExists(login, password);
    }

    public Customer getCustomer(String login) {
        return customerRepository.findByEmail(login);
    }

}
