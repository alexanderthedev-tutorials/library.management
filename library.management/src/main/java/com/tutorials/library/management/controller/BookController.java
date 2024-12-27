package com.tutorials.library.management.controller;

import com.tutorials.library.management.model.Book;
import com.tutorials.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
       return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
       return bookService.deleteBook(id);
    }
}
