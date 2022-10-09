package com.proyecto.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rutas")
public class Ruta {
	// n ́umero del bus, la fecha y hora para salir el bus en
	// plataforma, la cantidad de sillas vac ́ıas y Nombre conductor
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int numero_bus;

	private String fecha_hora;

	private int cantidad_sillas;

	@ManyToOne
	@JoinColumn(name = "conductor_id")
	private Conductor conductor;

	public Ruta(){

	}

	public Ruta(int id, int numero_bus, String fecha_hora, int cantidad_sillas, Conductor conductor) {
		this.id = id;
		this.numero_bus = numero_bus;
		this.fecha_hora = fecha_hora;
		this.cantidad_sillas = cantidad_sillas;
		this.conductor = conductor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_bus() {
		return numero_bus;
	}

	public void setNumero_bus(int numero_bus) {
		this.numero_bus = numero_bus;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getCantidad_sillas() {
		return cantidad_sillas;
	}

	public void setCantidad_sillas(int cantidad_sillas) {
		this.cantidad_sillas = cantidad_sillas;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	
}
