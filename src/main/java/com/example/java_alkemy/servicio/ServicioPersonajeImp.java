package com.example.java_alkemy.servicio;

import com.example.java_alkemy.modelo.Personaje;
import com.example.java_alkemy.repositorio.RepositorioPersonaje;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicioPersonajeImp implements ServicioPersonaje {
    private RepositorioPersonaje repositorioPersonaje;

    @Override
    public Personaje guardarUsuario(Personaje personaje) {

        return repositorioPersonaje.save(personaje);
    }

    @Override
    public Long eliminarPersonaje(Long id) {
        Personaje personaje = repositorioPersonaje.getById(id);
        repositorioPersonaje.deleteById(id);
        return personaje.getId();
    }

    @Override
    public Personaje traerPersonaje(Long id) {

        return repositorioPersonaje.findById(id).get();
    }

    @Override
    public List<Personaje> listarPersonajes() {
        return repositorioPersonaje.findAll();
    }


    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return repositorioPersonaje.findByNombre(nombre);
    }

    @Override
    public List<Personaje> buscarPorEdad(int edad) {
        return repositorioPersonaje.findByEdad(edad);
    }

    @Override
    public List<Personaje> buscarPorPelicula(String pelicula) {
        return repositorioPersonaje.findByPeliculas(pelicula);
    }


}
