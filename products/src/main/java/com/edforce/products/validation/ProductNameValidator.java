package com.edforce.products.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductNameValidator implements ConstraintValidator<ValidProductName, String> {

    @Override
    public boolean isValid(String productName, ConstraintValidatorContext constraintValidatorContext) {
        return productName.startsWith("P-");
    }
}
