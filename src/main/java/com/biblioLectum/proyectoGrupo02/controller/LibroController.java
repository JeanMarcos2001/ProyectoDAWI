package com.biblioLectum.proyectoGrupo02.controller;

import com.biblioLectum.proyectoGrupo02.model.Libro;
import com.biblioLectum.proyectoGrupo02.service.ICategoriaService;
import com.biblioLectum.proyectoGrupo02.service.ILibroService;
import com.biblioLectum.proyectoGrupo02.service.impl.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private UploadFileService uploadService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.listarTodos());
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias", categoriaService.listarTodos());
        return "libros";
    }

//    @PostMapping("/guardar")
//    public String guardarLibro(@ModelAttribute Libro libro,
//                               @RequestParam("file") MultipartFile file) { // Recibimos el archivo
//        try {
//            // LÓGICA DE IMAGEN
//            if (!file.isEmpty()) {
//                // Si suben archivo nuevo -> Guardamos y seteamos nombre
//                String nombreImagen = uploadService.guardarImagen(file);
//                libro.setPortadaUrl(nombreImagen);
//            } else {
//                // Si NO suben archivo...
//                if (libro.getId() == null) {
//                    // Y es nuevo -> Ponemos default
//                    libro.setPortadaUrl("default.jpg");
//                }
//                // Si es editar y no suben nada, se mantiene el que ya viene cargado en el form
//            }
//
//            libroService.guardar(libro);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/libros";
//    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro,
                               @RequestParam("file") MultipartFile file) {
        try {
            // --- INICIO DEPURACIÓN ---
            System.out.println("------------------------------------------------");
            System.out.println("DEBUG: Intentando guardar libro");
            System.out.println("DEBUG: Nombre del archivo: " + file.getOriginalFilename());
            System.out.println("DEBUG: Tamaño del archivo: " + file.getSize());
            System.out.println("DEBUG: ¿Está vacío?: " + file.isEmpty());
            System.out.println("DEBUG: Ruta actual del proyecto (user.dir): " + System.getProperty("user.dir"));
            System.out.println("------------------------------------------------");
            // --- FIN DEPURACIÓN ---

            if (!file.isEmpty()) {
                String nombreImagen = uploadService.guardarImagen(file);
                libro.setPortadaUrl(nombreImagen);
            } else {
                if (libro.getId() == null) {
                    libro.setPortadaUrl("default.jpg");
                }
            }
            libroService.guardar(libro);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        // Opcional: Borrar foto antigua antes de borrar el registro
        Libro l = libroService.buscarPorId(id);
        if (l != null) uploadService.eliminarImagen(l.getPortadaUrl());

        libroService.eliminar(id);
        return "redirect:/libros";
    }
}