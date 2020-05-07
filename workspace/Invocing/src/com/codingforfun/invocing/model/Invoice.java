package com.codingforfun.invocing.model;


import com.codingforfun.invocing.calculators.CurrentLocalDateCalculator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Invoice {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @Column(length = 32)
    private String oid;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int year;

    @Column(length = 6)
    private int number;

    @Required
    @Column(length = 50)
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate date;

    @Stereotype("MEMO")
    private String remarks;


}
