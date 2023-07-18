package com.hommies.cachingexample.repository;

import com.hommies.cachingexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    Optional<Book> findByAuthorAndTitle(String author, String title);
    Optional<Book> findByAuthor(String author);
}
