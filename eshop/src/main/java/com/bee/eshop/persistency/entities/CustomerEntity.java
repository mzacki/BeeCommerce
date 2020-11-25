package com.bee.eshop.persistency.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Matt on 10.09.2018 at 20:04.
 */

@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long customerId;
    private String firstName;
    private String lastName;
    private Date registrationDate = new Date();

    @OneToOne
    private AccountEntity accountEntity;
    // one to many
    //private List<Order> orders;

    protected CustomerEntity() {
        // for hibernate use only
    }

    public CustomerEntity(String firstName, String lastName, AccountEntity accountEntity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountEntity = accountEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public Long getRegistrationDate() {
        return registrationDate.getTime();
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = new Date(registrationDate.getTime());
    }

    public AccountEntity getAccount() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    /*public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/
}
