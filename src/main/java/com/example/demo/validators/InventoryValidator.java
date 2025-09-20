package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {

        // Make sure inventory is between min and max value
        if (part.getInv() > part.getMaxInv()) {
            // display error message
            constraintValidatorContext.buildConstraintViolationWithTemplate("Make sure your inventory value is less than the maximum value    ").addConstraintViolation();
            return false;
        }
        else if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Low inventory! Make sure your inventory value is higher than the minimum value").addConstraintViolation();
            return false;
        }
        else {
            return true;
        }

    }
}
