package com.example.java_alkemy.controlador;

import com.example.java_alkemy.modelo.Pelicula;
import com.example.java_alkemy.servicio.ServicioPelicula;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class ControladorPelicula {
    private final ServicioPelicula servicioPelicula;
    @GetMapping
    public ResponseEntity listarPeliculas() {
        return new ResponseEntity(servicioPelicula.listarPeliculas(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity guardarPelicula(@RequestBody Pelicula pelicula) {
        return new ResponseEntity(servicioPelicula.guardarPelicula(pelicula), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "borrar/{id}")
    public Long eliminarPelicula(@PathVariable("id") Long id) {
        return (servicioPelicula.eliminarPelicula(id));
    }
    @PatchMapping(path = "actualizar/{id}")
    public ResponseEntity ActualizarPelicula(@RequestBody Pelicula pelicula, @PathVariable("id") Long id) {
        Pelicula pelicula_actualizar = servicioPelicula.traerPelicula(id);
        pelicula_actualizar.setTitulo(pelicula.getImagen());
        pelicula_actualizar.setImagen(pelicula.getImagen());
        pelicula_actualizar.setFecha_creacion(pelicula.getFecha_creacion());


        return new ResponseEntity(servicioPelicula.guardarPelicula(pelicula_actualizar), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity buscarPelicula(@PathVariable("id") Long id) {
        return new ResponseEntity(servicioPelicula.traerPersonaje(id), HttpStatus.OK);
    }
    @GetMapping(params = "nombre")
    public ResponseEntity buscarPorNombre(@RequestParam("nombre") String nombre) {
        return new ResponseEntity(servicioPelicula.buscarPorNombre(nombre), HttpStatus.OK);
    }
    @GetMapping(params = "orden")
    public ResponseEntity ordenar(@RequestParam("orden") String orden) {
        return new ResponseEntity(servicioPelicula.ordenar(orden), HttpStatus.OK);
    }
    @PostMapping("/{peliculaId}/personajes/{personajeId}")
    public void agregarPersonaPelicula(@PathVariable Long peliculaId, @PathVariable Long personajeId) {
        servicioPelicula.agregarPersonaPelicula(peliculaId,personajeId);

    }
    @DeleteMapping("/{peliculaId}/personaje/{personajeId}")
    public void eliminarPersonaPelicula(@PathVariable Long peliculaId, @PathVariable Long personajeId) {
        servicioPelicula.eliminarPersonaPelicula(peliculaId,peliculaId);

    }
}
