package com.example.java_alkemy.servicio;

import com.example.java_alkemy.modelo.Pelicula;


import java.util.List;

public interface ServicioPelicula {


    List<Pelicula> listarPeliculas();

    Pelicula guardarPelicula(Pelicula pelicula);

    Long eliminarPelicula(Long id);

    Pelicula traerPelicula(Long id);

    Pelicula traerPersonaje(Long id);

    List<Pelicula> buscarPorNombre(String nombre);

    List<Pelicula> ordenar(String orden);

    void agregarPersonaPelicula(Long movieId, Long characterId);
    void eliminarPersonaPelicula(Long movieId, Long characterId);
}
