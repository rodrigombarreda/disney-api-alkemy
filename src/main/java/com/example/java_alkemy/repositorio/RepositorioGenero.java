package com.example.java_alkemy.repositorio;

import com.example.java_alkemy.modelo.Genero;
import com.example.java_alkemy.modelo.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioGenero extends JpaRepository<Genero, Long> {
}
