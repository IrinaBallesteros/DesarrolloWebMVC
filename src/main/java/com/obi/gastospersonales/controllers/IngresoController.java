package com.obi.gastospersonales.controllers;

import com.obi.gastospersonales.entities.Ingreso;
import com.obi.gastospersonales.repositories.CategoriaRepository;
import com.obi.gastospersonales.repositories.IngresosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@RequestMapping("/ingresos")
public class IngresoController {

    @Autowired
    private IngresosRepository ingresosRepository;
    @GetMapping
    public String listarIngresos(Model model) {
        model.addAttribute("ingresos", ingresosRepository.findAll());
        return "ingresos/listar_todo";
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/listar")
    public String listarTodos(Model model) {
        model.addAttribute("ingresos", ingresosRepository.findAll());
        return "ingresos/listar_todo";
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "ingresos/agregar";
    }

    @PostMapping("/agregar)")
    public String guardarIngreso(@ModelAttribute Ingreso ingreso) {
        ingresosRepository.save(ingreso);
        return "redirect:/ingresos";
    }

    @GetMapping("/buscar")
    public String buscarIngresos(@RequestParam(required = false) String descripcion,
                                 @RequestParam(required = false) LocalDate fecha,
                                 Model model) {

        model.addAttribute("resultados", ingresosRepository.findByDescripcionContainingIgnoreCaseOrFecha(descripcion, fecha));
        return "ingresos/buscar";

    }

    @GetMapping("/filtrar")
    public String filtrarIngresos(@RequestParam(required = false) Long categoriaId,
                                  @RequestParam(required = false) LocalDate fechaInicio,
                                  @RequestParam(required = false) LocalDate fechaFin,
                                  Model model) {

        model.addAttribute("ingresos", ingresosRepository.filtrarPorCriterios(categoriaId, fechaInicio, fechaFin));
        return "ingresos/lista_personalizada";
    }
}

