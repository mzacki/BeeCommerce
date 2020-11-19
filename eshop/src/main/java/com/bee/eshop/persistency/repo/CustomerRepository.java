package com.bee.eshop.persistency.repo;

import com.bee.eshop.persistency.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 10.09.2018 at 20:45.
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
