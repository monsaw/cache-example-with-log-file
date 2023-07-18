package com.hommies.cachingexample.controller;


import com.hommies.cachingexample.model.Book;
import com.hommies.cachingexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("all")
    public List<Book> allBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @GetMapping("author-{author}")
    public Book getBookByAuthor(@PathVariable String author) {return bookService.getBookByAuthorName(author); }

    @GetMapping("author-{author}/{title}-title")
    public Book getBookByAuthorAndTitle(@PathVariable String author, @PathVariable String title) {return bookService.getBookByAuthorNameAndTitle(author,title); }


    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {return bookService.getBookById(id); }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
}
