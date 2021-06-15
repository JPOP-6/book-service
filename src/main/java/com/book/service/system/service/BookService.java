package com.book.service.system.service;

import com.book.service.system.model.Book;
import com.book.service.system.model.dto.BookDTO;
import com.book.service.system.model.mapper.BookModelMapper;
import com.book.service.system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookModelMapper bookModelMapper;

    public BookService(@Autowired BookRepository bookRepository,
                       @Autowired BookModelMapper bookModelMapper) {
        this.bookRepository = bookRepository;
        this.bookModelMapper = bookModelMapper;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookModelMapper::toDto).collect(Collectors.toList());
    }

    public BookDTO getBookById(String id) {
        Book book = bookRepository.getById(id);
        return bookModelMapper.toDto(book);
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = bookModelMapper.toEntity(bookDTO);
        book = bookRepository.save(book);
        return bookModelMapper.toDto(book);
    }

    public void deleteBook(String id) {
        Book book = bookRepository.getById(id);
        bookRepository.delete(book);
    }

    public BookDTO updateBook(String id, BookDTO bookDTO) {
        if (bookRepository.existsById(id)) {
            Book book = bookRepository.getById(id);
            book = bookModelMapper.updateExceptPrice(book, bookDTO);
            book.setId(id);
            book = bookRepository.save(book);
            return bookModelMapper.toDto(book);
        }
        return null;
    }
}