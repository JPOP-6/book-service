package com.book.service.system.model.mapper;

import com.book.service.system.model.Book;
import com.book.service.system.model.dto.BookDTO;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookModelMapper {
    Book toEntity(BookDTO bookDTO);

    @Mappings({
            @Mapping(target = "price", ignore = true)
    })
    Book updateExceptPrice(@MappingTarget Book book, BookDTO bookDTO);

    BookDTO toDto(Book book);
}
