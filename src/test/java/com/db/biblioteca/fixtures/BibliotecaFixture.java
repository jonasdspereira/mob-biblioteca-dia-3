package com.db.biblioteca.fixtures;

import com.db.biblioteca.model.Biblioteca;

public class BibliotecaFixture {
    public static Biblioteca gerarBiblioteca(){
        return new Biblioteca("Nossa Biblioteca");
    }
}
