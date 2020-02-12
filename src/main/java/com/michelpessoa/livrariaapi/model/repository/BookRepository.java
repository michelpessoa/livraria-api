package com.michelpessoa.livrariaapi.model.repository;

import com.michelpessoa.livrariaapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
}
