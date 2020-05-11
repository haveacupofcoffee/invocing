package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@View(extendsView = "super.DEFAULT",
        members = "invoice {invoice}")

@View(name="NoCustomerNoInvoice",
    members =
        "year, number, date;" +
        "details;" +
        "remarks"
)

@Data
@Entity
public class Order extends CommercialDocument {

    @ManyToOne
    @ReferenceView("NoCustomerNoOrders")
    private Invoice invoice;
}
