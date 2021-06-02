package com.book.service.system.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BOOK")
@Data
@FieldNameConstants
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISHER")
    private String publisher;
}
