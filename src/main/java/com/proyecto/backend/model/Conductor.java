package com.proyecto.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "conductores")
public class Conductor {
	
	@Id
	private int id;

	private String nombre;

	private String fecha_ingreso;

	@OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Ruta> ruta;

	public Conductor(){

	}

	public Conductor(int id, String nombre, String fecha_ingreso, Set<Ruta> ruta) {
		this.id = id;
		this.nombre = nombre;
		this.fecha_ingreso = fecha_ingreso;
		this.ruta = ruta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Set<Ruta> getRuta() {
		return ruta;
	}

	public void setRuta(Set<Ruta> ruta) {
		this.ruta = ruta;
	}

	

}
