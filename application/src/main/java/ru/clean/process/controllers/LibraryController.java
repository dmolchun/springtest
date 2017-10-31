package ru.clean.process.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clean.process.api.dto.Book;
import ru.clean.process.api.service.LibraryBean;

import java.util.List;

/**
 * Created by dibragimov on 31.10.2017.
 * Crud operations controller
 */

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    @Autowired
    LibraryBean libraryBean;

    /**
     * Get all books from storage
     * @return books list
     */
    @RequestMapping(value = "/books")
    public List<Book> getAllBooks() {
        return libraryBean.getAllBooks();
    }
}
