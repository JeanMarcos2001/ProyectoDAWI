package com.biblioLectum.proyectoGrupo02.controller;

import com.biblioLectum.proyectoGrupo02.model.Libro;
import com.biblioLectum.proyectoGrupo02.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {
    @Autowired
    private ILibroService libroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listar(){
        return ResponseEntity.ok(libroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtener(@PathVariable Long id){
        Libro libro = libroService.buscarPorId(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Libro libro){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(libroService.guardar(libro));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar el libro");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro){
        if (libroService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        libro.setId(id);
        return ResponseEntity.ok(libroService.guardar(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        if (libroService.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro no existe");
        }
        libroService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Libro eliminado correctamente");
    }
}
