package com.proyecto.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.model.Conductor;
import com.proyecto.backend.repository.ConductorRepository;

@RestController
@RequestMapping("/api/v1")
public class ConductorController {

	@Autowired
	private ConductorRepository conductorRepository;

	//? Ver todos los autores
	@GetMapping("/Conductor")
	public List<Conductor> getConductors() {
		return conductorRepository.findAll();
	}

	//? Ver autor por ID
	@GetMapping("/Conductor/{ConductorId}")
	public Conductor getConductor(@PathVariable int ConductorId){
		Conductor c = conductorRepository.findById(ConductorId).get();
		return c;
	}

	//? Publicar autor
	@PostMapping("/Conductor")
	public Conductor saveConductor(@RequestBody Conductor Conductor){
		conductorRepository.save(Conductor);
		return Conductor;
	}

	//? Publicar varios autores
	@PostMapping("/Conductors")
	public List<Conductor> saveConductors(@RequestBody List<Conductor> ConductorsList){
		conductorRepository.saveAll(ConductorsList);
		return ConductorsList;
	}

	//? Actualizar autores
	@PutMapping("/Conductor/{ConductorId}")
	public Conductor putConductor(@PathVariable int ConductorId, @RequestBody Conductor Conductor){
		Conductor c = conductorRepository.findById(ConductorId).get();

		c.setNombre(Conductor.getNombre());
		c.setFecha_ingreso(Conductor.getFecha_ingreso());

		conductorRepository.save(c);
		return c;
	}

	//? Borrar autor
	@DeleteMapping("/Conductor/{ConductorId}")
	public Conductor deleteConductor(@PathVariable int ConductorId){
		Conductor c = conductorRepository.findById(ConductorId).get();
		conductorRepository.deleteById(ConductorId);

		return c;
	}

	@DeleteMapping("/Conductor")
	public void deleteAll(){
		conductorRepository.deleteAll();
	}
}
