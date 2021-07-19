package com.book.service.system.resource.api;

import com.book.service.system.utility.BookServiceResult;
import com.book.service.system.model.dto.BookDTO;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/books")
public interface BookServiceResource {
    @GetMapping("/")
    @NewSpan("book-service:getAllBooks")
    ResponseEntity<BookServiceResult> getAllBooks();

    @GetMapping("/{id}")
    @NewSpan("book-service:getBookById")
    ResponseEntity<BookServiceResult> getBookById(@SpanTag("book_id") @PathVariable("id") String id);

    @PostMapping("/")
    ResponseEntity<BookServiceResult> addBook(@RequestBody BookDTO book);

    @DeleteMapping("/{id}")
    ResponseEntity<BookServiceResult> deleteBook(@PathVariable("id") String id);

    @PutMapping("/{id}")
    ResponseEntity<BookServiceResult> updateBook(@PathVariable("id") String id, @RequestBody BookDTO bookDTO);
}
