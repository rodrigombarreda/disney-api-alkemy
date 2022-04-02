package com.example.java_alkemy.servicio;

import com.example.java_alkemy.modelo.Personaje;

import java.util.List;


public interface ServicioPersonaje {
    Personaje guardarUsuario(Personaje personaje);

    Long eliminarPersonaje(Long id);


    Personaje traerPersonaje(Long id);

    List<Personaje> listarPersonajes();



    List<Personaje> buscarPorNombre(String nombre);

    List<Personaje> buscarPorEdad(int edad);

    List<Personaje> buscarPorPelicula(String pelicula);
}
