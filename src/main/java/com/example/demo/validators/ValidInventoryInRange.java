package com.example.demo.validators;

import com.example.demo.validators.InventoryInRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = InventoryInRangeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventoryInRange {
    String message() default "Invalid cannot exceed 500 units";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    //int minInv() default 0;
    int maxInv() default 500;
}
