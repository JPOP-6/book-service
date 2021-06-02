package com.book.service.system.resource.impl;

import com.book.service.system.model.dto.BookDTO;
import com.book.service.system.resource.api.BookServiceResource;
import com.book.service.system.service.BookService;
import com.book.service.system.utility.BookServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BookServiceResourceImpl implements BookServiceResource {
    private final BookService bookService;

    public BookServiceResourceImpl(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<BookServiceResult> getAllBooks() {
        ResponseEntity<BookServiceResult> responseEntity;
        BookServiceResult bookServiceResult = new BookServiceResult();
        try {
            List<BookDTO> books = bookService.getAllBooks();
            bookServiceResult.setSuccess(true);
            bookServiceResult.setBooks(books);
            responseEntity = ResponseEntity.ok(bookServiceResult);
        } catch (Exception exception) {
            bookServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(bookServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<BookServiceResult> getBookById(int id) {
        ResponseEntity<BookServiceResult> responseEntity;
        BookServiceResult bookServiceResult = new BookServiceResult();
        try {
            BookDTO book = bookService.getBookById(id);
            bookServiceResult.setSuccess(true);
            bookServiceResult.setBooks(Collections.singletonList(book));
            responseEntity = ResponseEntity.ok(bookServiceResult);
        } catch (Exception exception) {
            bookServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(bookServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<BookServiceResult> addBook(BookDTO bookDTO) {
        ResponseEntity<BookServiceResult> responseEntity;
        BookServiceResult bookServiceResult = new BookServiceResult();
        try {
            BookDTO book = bookService.addBook(bookDTO);
            bookServiceResult.setSuccess(true);
            bookServiceResult.setBooks(Collections.singletonList(book));
            responseEntity = ResponseEntity.ok(bookServiceResult);
        } catch (Exception exception) {
            bookServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(bookServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<BookServiceResult> deleteBook(int id) {
        ResponseEntity<BookServiceResult> responseEntity;
        BookServiceResult bookServiceResult = new BookServiceResult();
        try {
            bookService.deleteBook(id);
            bookServiceResult.setSuccess(true);
            responseEntity = ResponseEntity.ok(bookServiceResult);
        } catch (Exception exception) {
            bookServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(bookServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<BookServiceResult> updateBook(int id, BookDTO bookDTO) {
        ResponseEntity<BookServiceResult> responseEntity;
        BookServiceResult bookServiceResult = new BookServiceResult();
        try {
            BookDTO book = bookService.updateBook(id, bookDTO);
            bookServiceResult.setSuccess(true);
            bookServiceResult.setBooks(Collections.singletonList(book));
            responseEntity = ResponseEntity.ok(bookServiceResult);
        } catch (Exception exception) {
            bookServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(bookServiceResult);
        }
        return responseEntity;
    }
}
