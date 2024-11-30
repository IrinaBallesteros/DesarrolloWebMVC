package com.obi.gastospersonales.services;

import com.obi.gastospersonales.entities.Gasto;
import com.obi.gastospersonales.repositories.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GastosService {

    @Autowired
    private GastosRepository gastosRepository;

    public List<Gasto> listarTodos() {
        return gastosRepository.findAll();
    }

    public Optional<Gasto> buscarPorId(Long id) {
        return gastosRepository.findById(id);
    }

    public List<Gasto> buscarPorDescripcionOFecha(String descripcion, LocalDate fecha) {
        return gastosRepository.findByDescripcionContainingIgnoreCaseOrFecha(descripcion, fecha);
    }

    public Gasto guardarGasto(Gasto gasto) {
        return gastosRepository.save(gasto);
    }

    public void eliminarGasto(Long id) {
        gastosRepository.deleteById(id);
    }

    public List<Gasto> filtrarPorCriterios(Long categoriaId, LocalDate fechaInicio, LocalDate fechaFin) {
        return gastosRepository.findByCategoriaIdAndFechaBetween(categoriaId, fechaInicio, fechaFin);
    }
}
