package com.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.backend.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {
	
}
