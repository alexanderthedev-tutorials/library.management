package com.tutorials.library.management.service;

import com.tutorials.library.management.model.Book;
import com.tutorials.library.management.repository.BookRepository;
import com.tutorials.library.management.repository.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository =  bookRepository;
    }

    public List<Book> getBooks() {
        var allBooksEntities = bookRepository.findAll();
        var result = new ArrayList<Book>();
        for (var bookEntity : allBooksEntities) {
            var book = Book.builder()
                    .id(bookEntity.getId())
                    .title(bookEntity.getTitle())
                    .author(bookEntity.getAuthor())
                    .build();

            result.add(book);
        }
        return result;
    }

    public Book addBook(Book book) {
        var bookEntity =
                BookEntity.builder()
                        .id(book.getId())
                        .author(book.getAuthor())
                        .title(book.getTitle())
                        .build();
        bookRepository.saveAndFlush(bookEntity);
        return book;
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        var bookEntityOptional = bookRepository.findById(id);
        if (bookEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        var bookEntity = bookEntityOptional.get();
        var updatedBookEntity = BookEntity.builder()
                .id(bookEntity.getId())
                .author(updatedBook.getAuthor())
                .title(updatedBook.getTitle())
                .build();

        bookRepository.saveAndFlush(updatedBookEntity);
       return Optional.of(updatedBook);
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book with id " + id + " was deleted";
    }
}
