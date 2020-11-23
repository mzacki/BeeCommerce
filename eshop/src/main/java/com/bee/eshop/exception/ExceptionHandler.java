package com.bee.eshop.exception;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final String ENTITY_NOT_FOUND = "Record not found in DB";
    private static final String CUSTOMER_ENTITY_NOT_FOUND = "Customer record not found in DB for customerId: {}";

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleEntityNotFound(RuntimeException exception) {
        LOG.error(ENTITY_NOT_FOUND, exception);
        return ResponseEntity.notFound().build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleCustomerNotFound(CustomerNotFoundException exception) {
        LOG.error(CUSTOMER_ENTITY_NOT_FOUND, exception.getCustomerId());
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("customerId", String.valueOf(exception.getCustomerId()));
        responseBody.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

}
