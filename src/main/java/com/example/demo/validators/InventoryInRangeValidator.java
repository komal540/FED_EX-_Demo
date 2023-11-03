package com.example.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryInRangeValidator implements ConstraintValidator<ValidInventoryInRange, Integer> {
    // private int minInv;
    private int maxInv;

    @Override
    public void initialize(ValidInventoryInRange constraintAnnotation) {
        //this.minInv = constraintAnnotation.minInv();
        this.maxInv = constraintAnnotation.maxInv();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid
        }
        return value <= maxInv;
        // >= minInv && value
    }
}
