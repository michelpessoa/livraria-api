package com.michelpessoa.livrariaapi.service.impl;

import com.michelpessoa.livrariaapi.exception.BusinessException;
import com.michelpessoa.livrariaapi.model.entity.Book;
import com.michelpessoa.livrariaapi.model.repository.BookRepository;
import com.michelpessoa.livrariaapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByIsbn(book.getIsbn())){
            throw new BusinessException("Isbn já cadastrado.");
        }

        return repository.save(book);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Book book) {
        repository.delete(book);
    }
}
