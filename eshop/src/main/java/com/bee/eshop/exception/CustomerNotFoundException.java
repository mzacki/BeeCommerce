package com.bee.eshop.exception;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends EntityNotFoundException {

    private final long customerId;

    public CustomerNotFoundException(String message, long customerId) {
        super(message);
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

}
