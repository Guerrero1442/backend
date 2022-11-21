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

import com.proyecto.backend.model.Ruta;
import com.proyecto.backend.repository.RutaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RutaController {

	@Autowired
	private RutaRepository rutaRepository;

	//? Ver todos los autores
	@GetMapping("/routes")
	public List<Ruta> getRutas() {
		return rutaRepository.findAll();
	}

	//? Ver autor por ID
	@GetMapping("/routes/{routeId}")
	public Ruta getRuta(@PathVariable int routeId){
		Ruta r = rutaRepository.findById(routeId).get();
		return r;
	}

	//? Publicar autor
	@PostMapping("/routes")
	public Ruta saveRuta(@RequestBody Ruta Ruta){
		rutaRepository.save(Ruta);
		return Ruta;
	}

	//? Publicar varios autores
	// @PostMapping("/Rutas")
	// public List<Ruta> saveRutas(@RequestBody List<Ruta> RutasList){
	// 	rutaRepository.saveAll(RutasList);
	// 	return RutasList;
	// }

	//? Actualizar autores
	@PutMapping("/routes/{routeId}")
	public Ruta putRuta(@PathVariable int routeId, @RequestBody Ruta ruta){
		Ruta r = rutaRepository.findById(routeId).get();

		r.setConductor(ruta.getConductor());
		r.setNumero_bus(ruta.getNumero_bus());
		r.setFecha_hora(ruta.getFecha_hora());
		r.setCantidad_sillas(ruta.getCantidad_sillas());

		rutaRepository.save(r);
		return r;
	}

	//? Borrar autor
	@DeleteMapping("/routes/{routeId}")
	public Ruta deleteRuta(@PathVariable int routeId){
		Ruta r = rutaRepository.findById(routeId).get();
		rutaRepository.deleteById(routeId);

		return r;
	}

	@DeleteMapping("/routes")
	public void deleteAll(){
		rutaRepository.deleteAll();
	}
}
