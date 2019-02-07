package com.kasiyanov.week6.practicespringboot.validation;

import com.kasiyanov.week6.practicespringboot.DTO.BookDTO;
import com.kasiyanov.week6.practicespringboot.util.ListFilter;
import com.kasiyanov.week6.practicespringboot.validation.annotation.AtLeastOneFieldNotBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class BookDtoValidator implements ConstraintValidator<AtLeastOneFieldNotBlank, BookDTO> {

    public void initialize(AtLeastOneFieldNotBlank constraint) {
    }

    @Override
    public boolean isValid(BookDTO value, ConstraintValidatorContext context) {
        List<String> filteredAuthorName = ListFilter.removeNullAndEmptyFields(value.getAuthorName());
        List<String> filteredGenre = ListFilter.removeNullAndEmptyFields(value.getGenre());
        return ((filteredAuthorName != null && filteredAuthorName.size() > 0) ||
                (filteredGenre != null && filteredGenre.size() > 0) ||
                (value.getStartYear() != null && value.getEndYear() != null)
        );
    }
}
