package com.portfolio.appreservas.repository;

import com.portfolio.appreservas.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Long> {
}