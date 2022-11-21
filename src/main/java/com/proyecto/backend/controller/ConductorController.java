package com.proyecto.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ConductorController {

	@Autowired
	private ConductorRepository conductorRepository;

	//? Ver todos los autores
	@GetMapping("/drivers")
	public List<Conductor> getConductors() {
		return conductorRepository.findAll();
	}

	//? Ver autor por ID
	@GetMapping("/drivers/{driverId}")
	public Conductor getConductor(@PathVariable int driverId){
		Conductor c = conductorRepository.findById(driverId).get();
		return c;
	}

	//? Publicar autor
	@PostMapping("/drivers")
	public Conductor saveConductor(@RequestBody Conductor Conductor){
		conductorRepository.save(Conductor);
		return Conductor;
	}

	//? Publicar varios autores
	// @PostMapping("/Conductor")
	// public List<Conductor> saveConductors(@RequestBody List<Conductor> ConductorsList){
	// 	conductorRepository.saveAll(ConductorsList);
	// 	return ConductorsList;
	// }

	//? Actualizar autores
	@PutMapping("/drivers/{driverId}")
	public Conductor putConductor(@PathVariable int driverId, @RequestBody Conductor Conductor){
		Conductor c = conductorRepository.findById(driverId).get();

		c.setNombre(Conductor.getNombre());
		c.setFecha_ingreso(Conductor.getFecha_ingreso());

		conductorRepository.save(c);
		return c;
	}

	//? Borrar autor
	@DeleteMapping("/drivers/{driverId}")
	public Conductor deleteConductor(@PathVariable int driverId){
		Conductor c = conductorRepository.findById(driverId).get();
		conductorRepository.deleteById(driverId);

		return c;
	}

	@DeleteMapping("/drivers")
	public void deleteAll(){
		conductorRepository.deleteAll();
	}
}
