package com.example.lab.mapper;

import com.example.lab.domain.entity.Author;
import com.example.lab.domain.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

    Author map(AuthorDto authorDto);

    AuthorDto map(Author author);
}
