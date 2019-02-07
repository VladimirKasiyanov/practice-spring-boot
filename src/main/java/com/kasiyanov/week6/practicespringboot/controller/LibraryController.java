package com.kasiyanov.week6.practicespringboot.controller;

import com.kasiyanov.week6.practicespringboot.entity.Book;
import com.kasiyanov.week6.practicespringboot.DTO.BookDTO;
import com.kasiyanov.week6.practicespringboot.service.BookService;
import com.kasiyanov.week6.practicespringboot.util.WriteCsvToResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryController {

    private final BookService bookService;

    @PostMapping(value = "/book/csv", produces = "text/csv")
    public void findBooksByFilter(@Valid @RequestBody BookDTO bookRequest, HttpServletResponse response)
            throws IOException {
        List<Book> books = bookService.getBooksByFilter(
                bookRequest.getAuthorName(),
                bookRequest.getGenre(),
                bookRequest.getStartYear(),
                bookRequest.getEndYear());
        response.setCharacterEncoding("UTF-8");
        WriteCsvToResponse.writeBooksToCsv(response.getWriter(), books);
    }
}