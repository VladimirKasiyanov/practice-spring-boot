package com.kasiyanov.week6.practicespringboot.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SqlRequest {

    public static String createSqlRequest(List<String> authorName, List<String> genre,
                                          Integer startYear, Integer endYear) {
        StringBuilder resultSQLRequest = new StringBuilder("SELECT book.name, book.creation_year, genre.name as book_genre," +
                " author.name as book_author\n" +
                "FROM book_storage.book\n" +
                "       JOIN book_storage.genre ON genre.id = book.genre_id\n" +
                "       JOIN book_storage.author ON author.id = book.author_id\n" +
                "WHERE ");

        if (authorName != null && authorName.size() > 0) {
            resultSQLRequest.append("(");
            for (int i = 0; i < authorName.size(); i++) {
                resultSQLRequest
                        .append("author.name = :authorName")
                        .append(i);
                if (i < authorName.size() - 1) {
                    resultSQLRequest.append(" OR ");
                }
            }
            resultSQLRequest.append(") ");
        }

        if (genre != null && genre.size() > 0) {
            if (authorName != null && authorName.size() > 0) {
                resultSQLRequest.append("AND ");
            }
            resultSQLRequest.append("(");
            for (int i = 0; i < genre.size(); i++) {
                resultSQLRequest
                        .append("genre.name = :genre")
                        .append(i);
                if (i < genre.size() - 1) {
                    resultSQLRequest.append(" OR ");
                }
            }
            resultSQLRequest.append(") ");
        }

        if (startYear != null && endYear != null) {
            if ((authorName != null && authorName.size() > 0) || (genre != null && genre.size() > 0)) {
                resultSQLRequest.append("AND (book.creation_year BETWEEN :startYear AND :endYear)");
            } else {
                resultSQLRequest.append("(book.creation_year BETWEEN :startYear AND :endYear)");
            }
        }

        return resultSQLRequest.toString();
    }
}
