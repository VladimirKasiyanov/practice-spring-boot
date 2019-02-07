package com.kasiyanov.week6.practicespringboot.dao;

import com.kasiyanov.week6.practicespringboot.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooksByFilter(List<String> authorName, List<String> genre,
                                Integer startYear, Integer endYear);
}
