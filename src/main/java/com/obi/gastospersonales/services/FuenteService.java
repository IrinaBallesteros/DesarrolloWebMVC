package com.obi.gastospersonales.services;

import com.obi.gastospersonales.entities.Fuente;
import com.obi.gastospersonales.repositories.FuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuenteService {

    @Autowired
    private FuenteRepository fuenteRepository;

    public List<Fuente> listarTodas() {
        return fuenteRepository.findAll();
    }

    public Optional<Fuente> buscarPorId(Long id) {
        return fuenteRepository.findById(id);
    }

    public Fuente guardarFuente(Fuente fuente) {
        return fuenteRepository.save(fuente);
    }

    public void eliminarFuente(Long id) {
        fuenteRepository.deleteById(id);
    }
}
