package com.kasiyanov.week6.practicespringboot.dao;

import com.kasiyanov.week6.practicespringboot.entity.Book;
import com.kasiyanov.week6.practicespringboot.util.SqlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final BookMapper bookMapper;

    @Override
    public List<Book> getBooksByFilter(List<String> authorName, List<String> genre,
                                       Integer startYear, Integer endYear) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        for (int i = 0; i < authorName.size(); i++) {
            parameterSource.addValue("authorName" + i, authorName.get(i));
        }
        for (int i = 0; i < genre.size(); i++) {
            parameterSource.addValue("genre" + i, genre.get(i));
        }
        parameterSource.addValue("startYear", startYear);
        parameterSource.addValue("endYear", endYear);

        String sqlRequest = SqlRequest.createSqlRequest(authorName, genre, startYear, endYear);

        return jdbcTemplate.query(sqlRequest, parameterSource, bookMapper);
    }
}