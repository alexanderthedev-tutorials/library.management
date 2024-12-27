package com.tutorials.library.management.service;

import com.tutorials.library.management.model.Book;
import com.tutorials.library.management.repository.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    private final List<Book> books = new ArrayList<>();

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository =  bookRepository;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Long id, Book updatedBook) {
        for (var book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
            }
            return book;
        }
        return null;
    }

    public String deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book with id " + id + "was deleted";
    }
}
