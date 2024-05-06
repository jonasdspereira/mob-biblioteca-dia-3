package com.db.biblioteca.services;

import com.db.biblioteca.model.Livro;

import java.util.List;

public interface LivroService {
    Livro buscarLivroPorId(Long id);

    List<Livro> buscarLivrosPorTituloEBibliotecaId(String titulo, Long bibliotecaId);

    List<Livro> buscarLivrosPorAutorEBibliotecaId(String autor, Long bibliotecaId);

    List<Livro> buscarLivrosPorAnoPublicacaoEBibliotecaId(Integer anoDePublicacao, Long bibliotecaId);

    List<Livro> buscarTodosLivrosPorBibliotecaId(Long bibliotecaId);

    List<Livro> buscarLivrosPorTitulo(String titulo);

    List<Livro> buscarLivrosPorAutor(String autor);

    List<Livro> buscarLivrosPorAnoDePublicacao(Integer anoDePublicacao);
}
