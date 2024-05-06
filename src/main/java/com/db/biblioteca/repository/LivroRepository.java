package com.db.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.biblioteca.model.Livro;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByTituloAndBibliotecaId(String titulo, Long bibliotecaId);
    List<Livro> findAllByAutorAndBibliotecaId(String autor, Long bibliotecaId);
    List<Livro> findAllByAnoDePublicacaoAndBibliotecaId(Integer anoDePublicacao, Long bibliotecaId);
    List<Livro> findAllByBibliotecaId(Long bibliotecaId);
    List<Livro> findAllByTitulo(String titulo);
    List<Livro> findAllByAutor(String autor);
    List<Livro> findAllByAnoDePublicacao(Integer anoDePublicacao);
}
