package com.example.java_alkemy.controlador;

import com.example.java_alkemy.modelo.Genero;
import com.example.java_alkemy.modelo.Personaje;
import com.example.java_alkemy.servicio.ServicioGenero;
import com.example.java_alkemy.servicio.ServicioPersonaje;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class ControladorGenero {
    private final ServicioGenero servicioGenero;
    @PostMapping
    public ResponseEntity guardarGenero(@RequestBody Genero genero){
        return new ResponseEntity(servicioGenero.guardarGenero(genero), HttpStatus.CREATED);
    }
}
