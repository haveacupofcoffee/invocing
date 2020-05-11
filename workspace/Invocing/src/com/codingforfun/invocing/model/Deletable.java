package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.Hidden;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Deletable extends Identifiable {

    @Hidden
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;
}
