package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@View(name = "Simple",  // This view is used only when “Simple” is specified
    members = "number, name"  // Shows only number and name in the same line
)

@Data
@Entity
public class Customer {

    @Id
    @Column(length = 20)
    private String number;

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
