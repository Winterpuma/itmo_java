package com.example.lab.mapper;

import com.example.lab.domain.dto.BookDto;
import com.example.lab.domain.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    Book map(BookDto bookDto);

    BookDto map(Book book);
}
