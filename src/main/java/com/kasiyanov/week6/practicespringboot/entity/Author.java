package com.kasiyanov.week6.practicespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
}
