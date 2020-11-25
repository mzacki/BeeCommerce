package com.bee.eshop.persistency.repo;

import com.bee.eshop.persistency.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 10.09.2018 at 20:45.
 */

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>,
        JpaSpecificationExecutor<CustomerEntity> {

}
