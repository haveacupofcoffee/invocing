package com.codingforfun.invocing.calculators;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;


public class NextNumberForYearCalculator implements ICalculator {

    @Getter
    @Setter
    private int year;

    @Override
    public Object calculate() throws Exception {
        Query query = XPersistence.getManager()
                .createQuery("select max(i.number) from CommercialDocument i" + " where i.year = :year");

        query.setParameter("year", year);
        Integer lastNumber = (Integer) query.getSingleResult();
        return lastNumber == null ? 1 : lastNumber + 1;
    }
}

