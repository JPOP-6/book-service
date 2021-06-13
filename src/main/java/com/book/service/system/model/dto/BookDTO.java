package com.book.service.system.model.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Data
@FieldNameConstants
public class BookDTO {
    private int id;
    private String title;
    private String category;
    private BigDecimal price;
    private String author;
    private String publisher;
}
