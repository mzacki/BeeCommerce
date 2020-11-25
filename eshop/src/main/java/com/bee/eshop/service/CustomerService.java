package com.bee.eshop.service;

import com.bee.eshop.persistency.entities.CustomerEntity;
import com.bee.eshop.persistency.filters.CustomerFilter;
import com.bee.eshop.persistency.repo.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerEntity> getCustomers(CustomerFilter filter) {
        return customerRepository.findAll(filter.toSpecification());
    }

}
