package com.codingforfun.invocing.calculators;

import org.openxava.calculators.ICalculator;

import java.time.LocalDate;

public class CurrentLocalDateCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {

        System.out.println(LocalDate.now());
        return LocalDate.now();
    }
}
