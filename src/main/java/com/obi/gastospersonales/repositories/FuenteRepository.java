package com.obi.gastospersonales.repositories;

import com.obi.gastospersonales.entities.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuenteRepository extends JpaRepository<Fuente, Long> {
    List<Fuente> findByNombreContainingIgnoreCase(String nombre);
}
