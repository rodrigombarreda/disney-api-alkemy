package com.example.java_alkemy.servicio;

import com.example.java_alkemy.modelo.Genero;
import com.example.java_alkemy.modelo.Pelicula;
import com.example.java_alkemy.modelo.Personaje;
import com.example.java_alkemy.repositorio.RepositorioGenero;
import com.example.java_alkemy.repositorio.RepositorioPelicula;
import com.example.java_alkemy.repositorio.RepositorioPersonaje;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ServicioPeliculaImp implements ServicioPelicula{
    private RepositorioPelicula repositorioPelicula;
    private RepositorioPersonaje repositorioPersonaje;
    private RepositorioGenero repositorioGenero;


    @Override
    public List<Pelicula> listarPeliculas() {
        return repositorioPelicula.findAll();
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {



        return repositorioPelicula.save(pelicula);
    }

    @Override
    public Long eliminarPelicula(Long id) {
        Pelicula pelicula = repositorioPelicula.getById(id);
        repositorioPelicula.deleteById(id);
        return pelicula.getId();
    }

    @Override
    public Pelicula traerPelicula(Long id) {

        return repositorioPelicula.findById(id).get();
    }

    @Override
    public Pelicula traerPersonaje(Long id) {
        return repositorioPelicula.findById(id).get();
    }

    @Override
    public List<Pelicula> buscarPorNombre(String nombre) {
        return repositorioPelicula.findByTitulo(nombre);
    }

    @Override
    public List<Pelicula> ordenar(String orden) {
        if (orden.equals("ASC")){
            return repositorioPelicula.findByOrderByIdAsc();
        }else{
            return repositorioPelicula.findByOrderByIdDesc();
        }

    }

    @Override
    public void agregarPersonaPelicula(Long movieId, Long characterId) {
        Pelicula pelicula = repositorioPelicula.getById(movieId);
        pelicula.getPersonajes().size();
        Personaje personaje = repositorioPersonaje.getById(characterId);
        pelicula.agregarPersonaje(personaje);
        repositorioPelicula.save(pelicula);
    }
    @Override
    public void eliminarPersonaPelicula(Long movieId, Long characterId) {
        Pelicula pelicula = repositorioPelicula.findById(movieId).get();
        Personaje personaje = repositorioPersonaje.findById(characterId).get();
        pelicula.eliminarPersonaje(personaje);
        repositorioPelicula.save(pelicula);
    }
}
