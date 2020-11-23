package com.bee.eshop.rest.controller;


import com.bee.eshop.persistency.entities.Customer;
import com.bee.eshop.persistency.filters.CustomerFilter;
import com.bee.eshop.persistency.repo.CustomerRepository;
import com.bee.eshop.service.CustomerService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matt on 10.09.2018 at 20:49.
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository,
            CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/all")
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //TODO return DTO form STRUCTURE instead of Entity directly
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomers(CustomerFilter filter) {
        return customerService.getCustomers(filter);
    }

}
