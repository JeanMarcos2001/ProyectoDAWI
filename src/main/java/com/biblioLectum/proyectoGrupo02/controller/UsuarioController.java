package com.biblioLectum.proyectoGrupo02.controller;

import com.biblioLectum.proyectoGrupo02.model.Usuario;
import com.biblioLectum.proyectoGrupo02.service.IPlanService;
import com.biblioLectum.proyectoGrupo02.service.IRolService;
import com.biblioLectum.proyectoGrupo02.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    // 1. Inyectamos los 3 servicios necesarios
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;

    @Autowired
    private IPlanService planService;

    // 2. LISTAR (GET)
    // Este método prepara TODO lo necesario para la página: la tabla y los desplegables del modal.
    @GetMapping
    public String listarUsuarios(Model model) {
        // A. La lista principal para la tabla
        model.addAttribute("usuarios", usuarioService.listarTodos());

        // B. El objeto vacío para el formulario "Nuevo Usuario"
        model.addAttribute("usuario", new Usuario());

        // C. Las listas para los <select> (Combos desplegables)
        model.addAttribute("listaRoles", rolService.listarTodos());
        model.addAttribute("listaPlanes", planService.listarTodos());

        return "usuarios"; // Retorna el archivo usuarios.html
    }

    // 3. GUARDAR (POST)
    // Sirve tanto para CREAR como para EDITAR (si el ID viene lleno)
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // 4. ELIMINAR (GET)
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}