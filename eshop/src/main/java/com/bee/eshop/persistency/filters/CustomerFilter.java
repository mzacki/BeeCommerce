package com.bee.eshop.persistency.filters;

import com.bee.eshop.persistency.entities.Customer;
import java.util.Date;
import org.springframework.data.jpa.domain.Specification;

public class CustomerFilter {

    private String firstName;
    private String lastName;
    private Long registrationDateFrom;
    private Long registrationDateTo;
    //private boolean newCustomer;
    //private boolean noAccount;
    //private List<Orders> orders;

    public Specification<Customer> toSpecification() {
        return CustomerSpecification.from(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getRegistrationDateFrom() {
        return registrationDateFrom;
    }

    public void setRegistrationDateFrom(Long registrationDateFrom) {
        this.registrationDateFrom = registrationDateFrom;
    }

    public Long getRegistrationDateTo() {
        return registrationDateTo;
    }

    public void setRegistrationDateTo(Long registrationDateTo) {
        this.registrationDateTo = registrationDateTo;
    }

    /* public boolean isNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(boolean newCustomer) {
        this.newCustomer = newCustomer;
    }

    public boolean isNoAccount() {
        return noAccount;
    }

    public void setNoAccount(boolean noAccount) {
        this.noAccount = noAccount;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }*/


}
