package com.codingforfun.invocing.model;

import lombok.Data;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @Column(length = 9)
    private int number;

    @Column(length = 50)
    @Required
    private String description;

    @ManyToOne( // The reference is persisted as a database relationship
            fetch=FetchType.LAZY, // The reference is loaded on demand
            optional=true) // The reference can have no value
    @DescriptionsList // Thus the reference is displayed using a combo
    private Category category; // A regular Java reference

    @Stereotype("MONEY") // The price property is used to store money
    private BigDecimal price; // Include the import java.math.*  BigDecimal is typically used for money

    @Stereotype("IMAGES_GALLERY") // A complete image gallery is available
    @Column(length=32) // The 32 length string is for storing the key of the gallery
    private String photos;

    @Stereotype("MEMO") // This is for a big text, a text area or equivalent will be used
    private String remarks;
}
