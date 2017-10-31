package ru.clean.process.service;

import ru.clean.process.api.dto.Book;
import ru.clean.process.api.dto.BookBuilder;
import ru.clean.process.api.service.LibraryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dibragimov on 31.10.2017.
 * LibraryBean base realization
 */
public class LibraryBeanImpl implements LibraryBean {

    /**
     * {@inheritDoc}
     */
    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            result.add(new BookBuilder().author("author" + i).name("name" + i).description("description" + i).build());
        }
        return result;
    }
}
