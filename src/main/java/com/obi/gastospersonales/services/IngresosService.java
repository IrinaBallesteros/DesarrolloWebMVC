package com.obi.gastospersonales.services;

import com.obi.gastospersonales.entities.Ingreso;
import com.obi.gastospersonales.repositories.IngresosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IngresosService {

    @Autowired
    private IngresosRepository ingresosRepository;

    public List<Ingreso> listarTodos() {
        return ingresosRepository.findAll();
    }

    public Optional<Ingreso> buscarPorId(Long id) {
        return ingresosRepository.findById(id);
    }

    public List<Ingreso> buscarPorDescripcionOFecha(String descripcion, LocalDate fecha) {
        return ingresosRepository.findByDescripcionContainingIgnoreCaseOrFecha(descripcion, fecha);
    }

    public Ingreso guardarIngreso(Ingreso ingreso) {
        return ingresosRepository.save(ingreso);
    }

    public void eliminarIngreso(Long id) {
        ingresosRepository.deleteById(id);
    }

    public List<Ingreso> filtrarPorCriterios(Long categoriaId, LocalDate fechaInicio, LocalDate fechaFin) {
        return ingresosRepository.findByCategoriaIdAndFechaBetween(categoriaId, fechaInicio, fechaFin);
    }
}
