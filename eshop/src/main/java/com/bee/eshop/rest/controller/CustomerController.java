package com.bee.eshop.rest.controller;


import com.bee.eshop.persistency.entities.Customer;
import com.bee.eshop.persistency.repo.CustomerRepository;

/**
 * Created by Matt on 10.09.2018 at 20:49.
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return CustomerRepository.save(customer);
    }

    @GetMapping
    public Iterable<Customer> getAll() {
        return CustomerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return CustomerRepository.findById(id).orElse(null);
    }

}
