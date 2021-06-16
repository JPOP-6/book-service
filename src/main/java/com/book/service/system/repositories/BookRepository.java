package com.book.service.system.repositories;

import com.book.service.system.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    Book getById(String id);
}
