package com.obi.gastospersonales.repositories;

import com.obi.gastospersonales.entities.Categoria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    List<Categoria> findAllByNomeContainingIgnoreCase(String nome);



}
