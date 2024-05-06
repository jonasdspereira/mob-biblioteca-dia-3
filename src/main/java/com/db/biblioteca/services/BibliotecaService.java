package com.db.biblioteca.services;

import com.db.biblioteca.model.Biblioteca;
import com.db.biblioteca.model.Livro;

import java.util.List;

public interface BibliotecaService {
    boolean adicionarLivroNaBiblioteca(Long bibliotecaId, Livro livro);

    Biblioteca buscarBibliotecaPorId(Long id);

    boolean verificarSeBibliotecaContemLivro(Biblioteca biblioteca, Livro livro);
    boolean removerLivroDaBiblioteca(Long bibliotecaId, Long livroId);

    Biblioteca criarBiblioteca(Biblioteca biblioteca);
    void removerBibliotecaPorId(Long bibliotecaId);
    List<Biblioteca> buscarTodasBibliotecas();
}
