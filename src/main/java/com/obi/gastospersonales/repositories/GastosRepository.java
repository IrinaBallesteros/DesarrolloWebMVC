package com.obi.gastospersonales.repositories;


import com.obi.gastospersonales.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface GastosRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByDescripcionContainingIgnoreCaseOrFecha(String descripcion, LocalDate fecha);
    List<Gasto> findByCategoriaIdAndFechaBetween(Long categoria_id, LocalDate fecha, LocalDate fecha2);

}
