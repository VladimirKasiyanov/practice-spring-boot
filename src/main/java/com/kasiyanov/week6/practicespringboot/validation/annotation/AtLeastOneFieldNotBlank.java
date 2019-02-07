package com.kasiyanov.week6.practicespringboot.validation.annotation;

import com.kasiyanov.week6.practicespringboot.validation.BookDtoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookDtoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneFieldNotBlank {

    String message() default "At least one filter field must not be blank}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
