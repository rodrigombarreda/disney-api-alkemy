package com.example.java_alkemy.repositorio;

import com.example.java_alkemy.modelo.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPersonaje extends JpaRepository<Personaje, Long> {

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(int edad);

    List<Personaje> findByPeliculas(String pelicula);
}

