package com.book.service.system.repositories;

import com.book.service.system.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findAll();

    Book getById(String id);
}
