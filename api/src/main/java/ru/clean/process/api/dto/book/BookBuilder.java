package ru.clean.process.api.dto.book;

/**
 * Created by dibragimov on 31.10.2017.
 * Builder for book instances
 */
public class BookBuilder {
    private String author;
    private String name;
    private String description;

    public BookBuilder() {
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder description(String description) {
        this.description = description;
        return this;
    }

    public Book build() {
        return new BookImpl(author, name, description);
    }

}
