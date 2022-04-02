package com.example.java_alkemy.repositorio;

import com.example.java_alkemy.modelo.Pelicula;
import com.example.java_alkemy.modelo.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioPelicula extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByTitulo(String nombre);
    List<Pelicula> findByOrderByIdAsc();
    List<Pelicula> findByOrderByIdDesc();
}
