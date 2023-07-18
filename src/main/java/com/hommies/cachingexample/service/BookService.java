package com.hommies.cachingexample.service;


import com.hommies.cachingexample.model.Book;
import com.hommies.cachingexample.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class);


    private final BookRepository bookRepository;

   // private final String BOOK_KEY = "books";

//



    @Cacheable(cacheNames = "cache1", key = "#id")
    public Book getBookById(Long id){

            Book book = bookRepository.findById(id).
                   orElse(null);
            logger.info("get a book by {}", id);
            System.out.println(">>> get a book>>>");
//
            return book;
        }

    @Cacheable(cacheNames = "cache1", key = "#author")
    public Book getBookByAuthorName(String author){

        Book book = bookRepository.findByAuthor(author).
                orElse(null);
        logger.info("get a book by {}", author);
        System.out.println(">>> get a book by author>>>");
//
        return book;
    }

    @Cacheable(cacheNames = "cache1", key = "#author + '-' + #title")
    public Book getBookByAuthorNameAndTitle(String author, String title){

        Book book = bookRepository.findByAuthorAndTitle(author, title).
                orElse(null);
        logger.info("get a book by author{} and title {}", author, title);
        System.out.println(">>> get a book by author and title>>>");
//
        return book;
    }

    @Cacheable(cacheNames = "cache1", key = "'#key'")
    public List<Book> getAllBooks(){

        logger.info("get all book");
        System.out.println(">>> get a book>>>");
        return bookRepository.findAll();

    }

    @CachePut(cacheNames = "cache1", key = "#result.id")
    public Book saveBook(Book book){
        logger.info("save a book by {}", book.getId());
        System.out.println(">>> save a book>>> book.getId()");
        return bookRepository.save(book);
    }

    @CacheEvict(cacheNames = "cache1", key = "#id")
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    @CachePut(cacheNames = "cache1", key = "#book.id")
    public Book updateBook (Book book){
        if(bookRepository.existsById(book.getId())){
            logger.info("update a book by {}", book.getId());
            System.out.println(">>> update a book>>> book.getId()");
            return bookRepository.save(book);
        }
    return null;}

}
