package com.obi.gastospersonales.controllers;

import com.obi.gastospersonales.entities.Fuente;
import com.obi.gastospersonales.repositories.FuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuentes")
public class FuenteController {

    @Autowired
    private FuenteRepository fuenteRepository;

    @GetMapping
    public String listarFuentes(Model model) {
        model.addAttribute("fuentes", fuenteRepository.findAll());
        return "fuentes/listar_todo";
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("fuente", new Fuente());
        return "fuentes/agregar";
    }

    @PostMapping("/agregar")
    public String guardarFuente(@ModelAttribute Fuente fuente) {
        fuenteRepository.save(fuente);
        return "redirect:/fuentes";
    }

    @GetMapping("/buscar")
    public String buscarFuentes(@RequestParam(required = false) String nombre, Model model) {
        model.addAttribute("resultados", fuenteRepository.findByNombreContainingIgnoreCase(nombre));
        return "fuentes/buscar";
    }

    @GetMapping("/editar/{id}")
    public String editarFuente(@PathVariable Long id, Model model) {
        Fuente fuente = fuenteRepository.findById(id).orElse(null);
        if (fuente != null) {
            model.addAttribute("fuente", fuente);
            return "fuentes/editar";
        } else {
            return "redirect:/fuentes";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarFuente(@PathVariable Long id, @ModelAttribute Fuente fuente) {
        fuente.setId(id);
        fuenteRepository.save(fuente);
        return "redirect:/fuentes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFuente(@PathVariable Long id) {
        fuenteRepository.deleteById(id);
        return "redirect:/fuentes";
    }
}
