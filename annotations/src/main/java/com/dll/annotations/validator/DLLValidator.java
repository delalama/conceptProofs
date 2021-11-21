package com.dll.annotations.validator;

import com.dll.annotations.annotations.DLLValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DLLValidator implements ConstraintValidator<DLLValidation, String>
{
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        return name.contains("DLL");
    }
}
