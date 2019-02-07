package com.kasiyanov.week6.practicespringboot.service;

import com.kasiyanov.week6.practicespringboot.dao.BookDao;
import com.kasiyanov.week6.practicespringboot.entity.Book;
import com.kasiyanov.week6.practicespringboot.util.ListFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookDao bookDao;

    public List<Book> getBooksByFilter(List<String> authorName, List<String> genre,
                                       Integer startYear, Integer endYear) {
        List<String> filteredAuthorName = ListFilter.removeNullAndEmptyFields(authorName);
        List<String> filteredGenre = ListFilter.removeNullAndEmptyFields(genre);

        return bookDao.getBooksByFilter(filteredAuthorName, filteredGenre, startYear, endYear);
    }
}
