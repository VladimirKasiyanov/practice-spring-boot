package com.kasiyanov.week6.practicespringboot.util;

import com.kasiyanov.week6.practicespringboot.entity.Book;
import lombok.experimental.UtilityClass;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class WriteCsvToResponse {

    public static void writeBooksToCsv(PrintWriter writer, List<Book> books) {
        try (
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.
                        withHeader("name", "create year", "genre", "author"))
        ) {
            for (Book book : books) {
                List<String> data = Arrays.asList(
                        book.getName(),
                        book.getCreationYear().toString(),
                        book.getGenre(),
                        book.getAuthor()
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }
}
