package com.michelpessoa.livrariaapi.service;

import com.michelpessoa.livrariaapi.model.entity.Book;

import java.util.Optional;

public interface BookService {
    Book save(Book any);

    Optional<Book> getById(Long id);

    void delete(Book book);
}
