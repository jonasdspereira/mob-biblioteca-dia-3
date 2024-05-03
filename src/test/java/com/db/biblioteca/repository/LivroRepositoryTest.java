package com.db.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.db.biblioteca.model.Biblioteca;
import com.db.biblioteca.model.Livro;

@SpringBootTest
@ActiveProfiles("test")
public class LivroRepositoryTest {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @AfterEach
    void tearDown() {
        livroRepository.deleteAll();
        bibliotecaRepository.deleteAll();
    }

    @Test
    void testeCriarLivro() {
        Biblioteca biblioteca = new Biblioteca("Amazonino Mendes");
        bibliotecaRepository.save(biblioteca);
        Livro livro = new Livro("O menino do pijama listrado", "John Boyne", 2005, biblioteca);
        livroRepository.save(livro);

        List<Livro> livros = livroRepository.findAll();
        List<Biblioteca> bibliotecas = bibliotecaRepository.findAll();

        assertEquals(1, livros.size());
        assertEquals(1, bibliotecas.size());
    }

}
