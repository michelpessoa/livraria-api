package com.michelpessoa.livrariaapi.model.repository;

import com.michelpessoa.livrariaapi.model.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository repository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um livro na base com o isbn informado ")
    public void returnTrueWhenIsbnExists(){
        //Cenário
        String isbn = "123";
        Book book = Book.builder().title("Aventuras").author("Fulano").isbn("123").build();
        entityManager.persist(book);

        //Execução
        boolean exits = repository.existsByIsbn(isbn);

        //Verificação
        assertThat(exits).isTrue();
    }

    @Test
    @DisplayName("Deve retornar falso quando não existir um livro na base com o isbn informado ")
    public void returnFalseWhenIsbnExists(){
        //Cenário
        String isbn = "123";

        //Execução
        boolean exits = repository.existsByIsbn(isbn);

        //Verificação
        assertThat(exits).isFalse();
    }
}
