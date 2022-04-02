package com.example.java_alkemy.controlador;

import com.example.java_alkemy.modelo.Personaje;
import com.example.java_alkemy.servicio.ServicioPersonaje;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personajes")
@RequiredArgsConstructor
public class ControladorPersonaje {
    private final ServicioPersonaje servicioPersonaje;

    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody Personaje personaje) {
        return new ResponseEntity(servicioPersonaje.guardarUsuario(personaje), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "borrar/{id}")
    public Long eliminarPersonaje(@PathVariable("id") Long id) {
        return (servicioPersonaje.eliminarPersonaje(id));
    }

    @PatchMapping(path = "actualizar/{id}")
    public ResponseEntity ActualizarPersonaje(@RequestBody Personaje personaje, @PathVariable("id") Long id) {
        Personaje personaje_actualizar = servicioPersonaje.traerPersonaje(id);
        personaje_actualizar.setImagen(personaje.getImagen());
        personaje_actualizar.setNombre(personaje.getNombre());
        personaje_actualizar.setEdad(personaje.getEdad());
        personaje_actualizar.setPeso(personaje.getPeso());
        personaje_actualizar.setHistoria(personaje.getHistoria());

        return new ResponseEntity(servicioPersonaje.guardarUsuario(personaje_actualizar), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity buscarPersonaje(@PathVariable("id") Long id) {
        return new ResponseEntity(servicioPersonaje.traerPersonaje(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity listarPersonajes() {
        return new ResponseEntity(servicioPersonaje.listarPersonajes(), HttpStatus.OK);
    }

    @GetMapping(params = "nombre")
    public ResponseEntity buscarPorNombre(@RequestParam("nombre") String nombre) {
        return new ResponseEntity(servicioPersonaje.buscarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping(params = "edad")
    public ResponseEntity buscarPorEdad(@RequestParam("edad") int edad) {
        return new ResponseEntity(servicioPersonaje.buscarPorEdad(edad), HttpStatus.OK);
    }

    @GetMapping(params = "pelicula")
    public ResponseEntity buscarPorPelicula(@RequestParam("pelicula") String pelicula) {
        return new ResponseEntity(servicioPersonaje.buscarPorPelicula(pelicula), HttpStatus.OK);
    }
}
