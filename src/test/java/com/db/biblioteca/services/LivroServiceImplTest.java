package com.db.biblioteca.services;

import com.db.biblioteca.fixtures.BibliotecaFixture;
import com.db.biblioteca.fixtures.LivroFixture;
import com.db.biblioteca.model.Livro;
import com.db.biblioteca.repository.LivroRepository;
import com.db.biblioteca.services.impl.LivroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LivroServiceImplTest {

    @InjectMocks
    private LivroServiceImpl livroServiceImpl;

    @Mock
    private LivroRepository livroRepository;

    private Livro livro;

    @BeforeEach
    void setup() {
        livro = LivroFixture.gerarLivro(BibliotecaFixture.gerarBiblioteca());
    }

    @Test
    @DisplayName("Deve ser possivel buscar livro pelo ID")
    void deveEncontrarLivroPeloId () {
        when(this.livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        assertDoesNotThrow(() -> this.livroServiceImpl.buscarLivroPorId(1L));
    }

    @Test
    @DisplayName("Nao deve ser possivel buscar livro pelo ID")
    void naoDeveEncontrarLivroPeloId () {
        when(this.livroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> this.livroServiceImpl.buscarLivroPorId(1L));
    }

    @Test
    @DisplayName("Deve retornar livros por titulo")
    void deveRetornarLivrosPorTituloNaBiblioteca () {
        List<Livro> livros = LivroFixture.gerarListaDeLivrosMesmoTitulo();
        String titulo = livros.get(0).getTitulo();
        when(this.livroRepository.findAllByTituloAndBibliotecaId(titulo, 1L)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorTituloEBibliotecaId(titulo, 1L);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar livros por autor na biblioteca")
    void deveRetornarLivrosPorAutorNaBiblioteca () {
        List<Livro> livros = LivroFixture.gerarListaDeLivrosMesmoAutor();
        String autor = livros.get(0).getAutor();
        when(this.livroRepository.findAllByAutorAndBibliotecaId(autor, 1L)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorAutorEBibliotecaId(autor, 1L);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar livros por ano de publicacao na biblioteca")
    void deveRetornarLivrosPorAnoDePublicacaoNaBiblioteca () {
        List<Livro> livros = LivroFixture.gerarListaDeLivrosMesmoAnoDePublicacao();
        Integer anoDePublicacao = livros.get(0).getAnoDePublicacao();
        when(this.livroRepository.findAllByAnoDePublicacaoAndBibliotecaId(anoDePublicacao, 1L)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorAnoPublicacaoEBibliotecaId(anoDePublicacao, 1L);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar todos os livros na biblioteca")
    void deveRetornarTodosLivrosNaBiblioteca () {
        List<Livro> livros = LivroFixture.gerarListaDeLivros();
        when(this.livroRepository.findAllByBibliotecaId(1L)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarTodosLivrosPorBibliotecaId(1L);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar todos os livros por titulo")
    void deveRetornarTodosLivrosPorTitulo () {
        List<Livro> livros = LivroFixture.gerarListaDeLivros();
        String titulo = livros.get(0).getTitulo();
        when(this.livroRepository.findAllByTitulo(titulo)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorTitulo(titulo);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar todos os livros por autor")
    void deveRetornarTodosLivrosPorAutor () {
        List<Livro> livros = LivroFixture.gerarListaDeLivros();
        String autor = livros.get(0).getAutor();
        when(this.livroRepository.findAllByAutor(autor)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorAutor(autor);
        assertEquals(livros, resposta);
    }

    @Test
    @DisplayName("Deve retornar todos os livros por ano de publicacao")
    void deveRetornarTodosLivrosPorAnoDePublicacao () {
        List<Livro> livros = LivroFixture.gerarListaDeLivrosMesmoAnoDePublicacao();
        Integer anoDePublicacao = livros.get(0).getAnoDePublicacao();
        when(this.livroRepository.findAllByAnoDePublicacao(anoDePublicacao)).thenReturn(livros);

        List<Livro> resposta = livroServiceImpl.buscarLivrosPorAnoDePublicacao(anoDePublicacao);
        assertEquals(livros, resposta);
    }
}
