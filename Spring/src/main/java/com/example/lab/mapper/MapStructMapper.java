package com.example.lab.mapper;

import com.example.lab.domain.dto.*;
import com.example.lab.domain.entity.Author;
import com.example.lab.domain.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    BookSlimDto mapSlim(Book book);

    BookDto map(Book book);

    Book map(BookDto book);
    List<BookDto> mapListBook(List<Book> authors);

    Author map(AuthorAllDto author);

    AuthorDto map(Author author);

    AuthorAllDto mapAll(Author author);

    List<AuthorAllDto> mapListAuthor(List<Author> authors);
}
