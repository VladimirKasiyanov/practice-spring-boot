package com.kasiyanov.week6.practicespringboot.DTO;

import com.kasiyanov.week6.practicespringboot.validation.annotation.AtLeastOneFieldNotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AtLeastOneFieldNotBlank
public class BookDTO {

    private List<String> authorName;

    private List<String> genre;

    private Integer startYear;

    private Integer endYear;
}
