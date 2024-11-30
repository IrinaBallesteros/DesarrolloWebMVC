package com.obi.gastospersonales.repositories;

import com.obi.gastospersonales.entities.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IngresosRepository extends JpaRepository<Ingreso, Long> {

    List<Ingreso> findByDescripcionContainingIgnoreCase(String descripcion);

    List<Ingreso> findByFecha(LocalDate fecha);

    List<Ingreso> findByDescripcionContainingIgnoreCaseOrFecha(String descripcion, LocalDate fecha);

    List<Ingreso> findByCategoriaIdAndFechaBetween(Long categoriaId, LocalDate fechaInicio, LocalDate fechaFin);

    List<Ingreso> findByCategoriaId(Long categoriaId);

    @Query("SELECT i FROM Ingreso i WHERE (i.categoria.id = :categoriaId OR :categoriaId IS NULL) AND (i.fecha BETWEEN :fechaInicio AND :fechaFin OR :fechaInicio IS NULL OR :fechaFin IS NULL)")
    List<Ingreso> filtrarPorCriterios(@Param("categoriaId") Long categoriaId,
                                      @Param("fechaInicio") LocalDate fechaInicio,
                                      @Param("fechaFin") LocalDate fechaFin);
}
