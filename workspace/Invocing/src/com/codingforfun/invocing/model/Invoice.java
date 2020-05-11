package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;


@View(extendsView = "super.DEFAULT",
        members = "orders {orders}"
)

@View(name="NoCustomerNoOrders",
        members = "year, number, date;" +
                "details;" +
                "remarks"

)

@Data
@Entity
public class Invoice extends CommercialDocument {

    @OneToMany(mappedBy = "invoice")
    @CollectionView("NoCustomerNoInvoice")
    private Collection<Order> orders;
}
