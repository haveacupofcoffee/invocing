package com.codingforfun.invocing.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable  // We use @Embeddable instead of @Entity
public class Address {

    @Column(length = 30)   //The members are annotated as in entity case
    private String street;

    @Column(length = 5)
    private int zipCode;

    @Column(length = 20)
    private String city;

    @Column(length = 30)
    private String state;


}
