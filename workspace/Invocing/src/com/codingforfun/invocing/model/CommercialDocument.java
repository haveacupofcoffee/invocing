package com.codingforfun.invocing.model;


import com.codingforfun.invocing.calculators.CurrentLocalDateCalculator;
import com.codingforfun.invocing.calculators.NextNumberForYearCalculator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@View(members =
    "year, number, date;" +
    "data {" +
        "customer;" +
        "details;" +
        "remarks" +
    "}"
)

@Data
@Entity
abstract public class CommercialDocument extends Deletable {

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int year;

    @Column(length = 6)
    @DefaultValueCalculator(value = NextNumberForYearCalculator.class, properties = @PropertyValue(name="year"))
    private int number;

    @Required
    @Column(length = 50)
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    @Stereotype("LOCALDATE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    private Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    private Collection<Detail> details;

    @Stereotype("MEMO")
    private String remarks;



}
