package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
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
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PartService repo = myContext.getBean(PartServiceImpl.class);
        if (part.getId() != 0) {
            Part myPart = repo.findById((int) part.getId());

            if (part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv()) {
                return true;
            }
            else {
                constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be within minimum and maximum.")
                        .addPropertyNode("inv")
                        .addConstraintViolation();
                return false;
            }
        }
        else {
            return true;
        }
    }
}