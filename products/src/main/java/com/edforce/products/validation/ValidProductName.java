package com.edforce.products.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProductNameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductName {
    String message() default "Invalid Product Name. Product name must start with 'P-'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
