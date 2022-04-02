package com.example.java_alkemy.servicio;

import com.example.java_alkemy.modelo.Genero;
import com.example.java_alkemy.repositorio.RepositorioGenero;
import com.example.java_alkemy.repositorio.RepositorioPersonaje;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicioGeneroImp implements ServicioGenero{
    private RepositorioGenero repositorioGenero;
    @Override
    public Genero guardarGenero(Genero genero) {
        return repositorioGenero.save(genero);
    }
}
