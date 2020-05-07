package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @Column(length = 20)
    private String id;

    @Column(length =  50)
    @Required
    private String name;

    @Embedded
    @Column(length = 50)
    private Address address;

    public Address getAddress() {
        if(address == null) {
            address = new Address();
        }
        return address;
    }
}
