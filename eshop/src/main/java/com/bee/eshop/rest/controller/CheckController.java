package com.bee.eshop.rest.controller;

import com.bee.eshop.persistency.entities.CustomerEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matt on 10.09.2018 at 20:04.
 */

@RestController
public class CheckController {
    @GetMapping("/check")
    public String check() {
        return "Controller works!";

    }
    @GetMapping("/check/{variable}")
    public String checkPathVariable(@PathVariable String variable) {
        return "Path variable: " + variable;
    }

    @PostMapping("/checkRequestBody")
    public String checkRequestBody(@RequestBody String requestBody) {
        return "Request body: " + requestBody;
    }

    @GetMapping("/check")
    public CustomerEntity example4(@Param("firstName") String firstName, @Param("lastName") String lastName) {
        return new CustomerEntity("First name " + firstName, "Last name " + lastName, account);
    }

}
