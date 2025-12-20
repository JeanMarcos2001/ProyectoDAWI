package com.biblioLectum.proyectoGrupo02.controller;

import com.biblioLectum.proyectoGrupo02.model.Plan;
import com.biblioLectum.proyectoGrupo02.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param; // Importación necesaria

import java.util.List;


@Controller
@RequestMapping("/planes")
public class PlanController {

    private final PlanRepository repository;

    public PlanController(PlanRepository repository)
    {
        this.repository = repository;
    }




    @GetMapping
    public String listarPlanes(Model model, @RequestParam(value = "palabraClave", required = false) String palabraClave) {

        List<Plan> lista;

        if (palabraClave != null && !palabraClave.isEmpty()) {
            // Si hay búsqueda, usamos nuestro método nuevo
            lista = repository.findByNombreContainingIgnoreCase(palabraClave);
        } else {
            // Si no, traemos todo
            lista = repository.findAll();
        }

        model.addAttribute("planes", lista);
        model.addAttribute("plan", new Plan()); // Para el modal de crear
        model.addAttribute("palabraClave", palabraClave); // Para mantener el texto en la cajita

        return "planes";
    }

    // 1. Muestra el formulario vacío para registrar
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrar(Model model) {
        // Enviamos un objeto vacio para que el formulario lo llene
        model.addAttribute("plan", new Plan());
        model.addAttribute("titulo", "Nuevo Plan");
        return "plan_form"; // Este será nuestro nuevo HTML
    }

    // 2. Recibe los datos del formulario y los guarda en la BD
    @PostMapping("/guardar")
    public String guardarPlan(@ModelAttribute Plan plan) {
        // El repositorio hace la magia: inserta si es nuevo, actualiza si tiene ID
        repository.save(plan);
        return "redirect:/planes"; // Al terminar, nos manda de vuelta a la lista
    }

    // 3. EDITAR: Busca el plan por ID y muestra el mismo formulario de antes
    @GetMapping("/editar/{id}")
    public String editarPlan(@PathVariable Long id, Model model) {
        // Buscamos el plan en la BD. Si no existe, devuelve null.
        Plan plan = repository.findById(id).orElse(null);

        // Ponemos el plan encontrado en el modelo para que el formulario se llene solo
        model.addAttribute("plan", plan);

        return "plan_form"; // ¡Reutilizamos el mismo HTML de registro!
    }

    // 4. ELIMINAR: Borra el plan por ID y recarga la lista
    @GetMapping("/eliminar/{id}")
    public String eliminarPlan(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/planes";
    }

}
