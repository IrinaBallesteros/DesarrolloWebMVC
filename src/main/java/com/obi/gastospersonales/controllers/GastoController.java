package com.obi.gastospersonales.controllers;

import com.obi.gastospersonales.entities.Gasto;
import com.obi.gastospersonales.repositories.CategoriaRepository;
import com.obi.gastospersonales.repositories.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastosRepository gastosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarGastos(Model model) {
        List<Gasto> gastos = gastosRepository.findAll();
        model.addAttribute("gastos", gastos);
        return "gastos/listar_todo";
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("gasto", new Gasto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "gastos/agregar";
    }

    public String guardarGasto(@ModelAttribute Gasto gasto) {
        gastosRepository.save(gasto);
        return "redirect:/gastos";
    }
}
