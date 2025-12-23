package com.biblioLectum.proyectoGrupo02.controller;


import com.biblioLectum.proyectoGrupo02.model.Categoria;
import com.biblioLectum.proyectoGrupo02.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodos());
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria){

        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping ("/eliminar/{id}")
    public String eliminarCategoria(Long id){
        categoriaService.eliminar(id);
        return "redirect:/categoria";
    }

}
