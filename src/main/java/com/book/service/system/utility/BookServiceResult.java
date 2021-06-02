package com.book.service.system.utility;

import com.book.service.system.model.dto.BookDTO;
import lombok.Data;

import java.util.List;

@Data
public class BookServiceResult {
    private boolean isSuccess;
    private String error;
    private List<BookDTO> books;
}
