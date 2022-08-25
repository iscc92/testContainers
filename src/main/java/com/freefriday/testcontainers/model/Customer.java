package com.freefriday.testcontainers.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Customer {

    private long id;
    private String name;
    private String lastName;

    public Customer(long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
