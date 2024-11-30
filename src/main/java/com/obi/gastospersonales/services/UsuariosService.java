package com.obi.gastospersonales.services;

import com.obi.gastospersonales.entities.Usuario;
import com.obi.gastospersonales.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuario> listarTodos() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    public boolean existePorCorreo(String correo) {
        return usuariosRepository.existsByCorreo(correo);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}
