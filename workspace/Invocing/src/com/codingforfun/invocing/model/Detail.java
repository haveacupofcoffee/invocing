package com.codingforfun.invocing.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Embeddable
public class Detail {

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Product product;
}
