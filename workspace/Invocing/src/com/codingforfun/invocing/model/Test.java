package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Stereotype;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Test extends Identifiable {

    @Stereotype("REGIONS")
    private String[] regions;

}
