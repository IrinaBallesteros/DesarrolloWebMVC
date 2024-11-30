package com.obi.gastospersonales.controllers;

import com.obi.gastospersonales.entities.Usuario;
import com.obi.gastospersonales.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuariosService.listarTodos());
        return "usuarios/listar_todo";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/agregar";
    }

    @PostMapping("/agregar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuariosService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuariosService.buscarPorId(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/editar";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/editar")
    public String actualizarUsuario(@ModelAttribute Usuario usuario) {
        usuariosService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/buscar")
    public String buscarUsuarioPorCorreo(@RequestParam String correo, Model model) {
        Optional<Usuario> usuario = usuariosService.buscarPorCorreo(correo);
        model.addAttribute("resultado", usuario.orElse(null));
        return "usuarios/buscar";
    }
}
