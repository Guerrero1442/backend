package com.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.backend.model.Conductor;

public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
	
}
