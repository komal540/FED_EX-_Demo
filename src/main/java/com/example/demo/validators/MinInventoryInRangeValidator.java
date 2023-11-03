package com.example.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinInventoryInRangeValidator implements ConstraintValidator<ValidMinInventoryInRange, Integer> {
    private int minInv;
    // private int maxInv;

    @Override
    public void initialize(ValidMinInventoryInRange constraintAnnotation) {
        this.minInv = constraintAnnotation.minInv();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid
        }
        return value >= minInv;
        //  && value <= maxInv
    }
}
