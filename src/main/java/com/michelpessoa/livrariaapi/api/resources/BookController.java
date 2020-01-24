package com.michelpessoa.livrariaapi.api.resources;

import com.michelpessoa.livrariaapi.api.dto.BookDTO;
import com.michelpessoa.livrariaapi.model.entity.Book;
import com.michelpessoa.livrariaapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto) {

        Book entity = Book.builder().author(dto.getAuthor()).isbn(dto.getIsbn()).title(dto.getTitle()).build();

        entity = service.save(entity);

        return BookDTO.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .title(entity.getTitle())
                .build();
    }

}
