package ru.clean.process.api.service;

import ru.clean.process.api.dto.Book;

import java.util.List;

/**
 * Created by dibragimov on 31.10.2017.
 * Library base functionality bean
 */
public interface LibraryBean {

    /**
     * Get all books from storage
     * @return books list
     */
    List<Book> getAllBooks();
}
