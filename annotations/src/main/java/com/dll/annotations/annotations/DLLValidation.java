package com.dll.annotations.annotations;

import com.dll.annotations.validator.DLLValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DLLValidator.class)
public @interface DLLValidation {
    String message() default "Invalid name: must be DLL";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
