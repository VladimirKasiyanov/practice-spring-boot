package com.kasiyanov.week6.practicespringboot.dao;

import com.kasiyanov.week6.practicespringboot.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setName(resultSet.getString("name"));
        book.setCreationYear(resultSet.getInt("creation_year"));
        book.setGenre(resultSet.getString("book_genre"));
        book.setAuthor(resultSet.getString("book_author"));
        return book;
    }
}
