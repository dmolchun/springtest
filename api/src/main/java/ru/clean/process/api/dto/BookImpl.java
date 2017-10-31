package ru.clean.process.api.dto;

import java.io.Serializable;

/**
 * Created by dibragimov on 31.10.2017.
 * DTO for book description
 */
public class BookImpl implements Book, Serializable {

    private String author;
    private String name;
    private String description;

    public BookImpl(String author, String name, String description) {
        this.author = author;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
