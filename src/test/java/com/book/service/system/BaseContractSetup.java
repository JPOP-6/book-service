package com.book.service.system;

import com.book.service.system.model.dto.BookDTO;
import com.book.service.system.service.BookService;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static wiremock.com.google.common.base.Charsets.UTF_8;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseContractSetup {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    BookService bookService;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.config = new RestAssuredMockMvcConfig()
                .encoderConfig(new EncoderConfig(UTF_8.name(), UTF_8.name()));

        RestAssuredMockMvc.webAppContextSetup(context);

        Mockito.when(bookService.getAllBooks()).thenReturn(getAllBooks());
        Mockito.when(bookService.getBookById("1")).thenReturn(getBookById1());
        Mockito.when(bookService.addBook(any())).thenReturn(getBookById1());
        Mockito.when(bookService.updateBook(any(), any())).thenReturn(getBookById1());
    }

    private List<BookDTO> getAllBooks() {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setId("1");
        bookDTO1.setTitle("title1");
        bookDTO1.setCategory("category1");
        bookDTO1.setPublisher("publisher1");
        bookDTO1.setPrice(BigDecimal.valueOf(100));
        bookDTO1.setAuthor("author1");
        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setId("2");
        bookDTO2.setTitle("title2");
        bookDTO2.setCategory("category2");
        bookDTO2.setPublisher("publisher2");
        bookDTO2.setPrice(BigDecimal.valueOf(200));
        bookDTO2.setAuthor("author2");
        return Arrays.asList(bookDTO1, bookDTO2);
    }

    private BookDTO getBookById1() {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setId("1");
        bookDTO1.setTitle("title1");
        bookDTO1.setCategory("category1");
        bookDTO1.setPublisher("publisher1");
        bookDTO1.setPrice(BigDecimal.valueOf(100));
        bookDTO1.setAuthor("author1");
        return bookDTO1;
    }
}