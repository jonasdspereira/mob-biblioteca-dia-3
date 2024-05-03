package com.db.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.biblioteca.model.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

}
