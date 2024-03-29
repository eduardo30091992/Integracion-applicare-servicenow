package com.example.proyectoscp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class empresa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String contacto;
	
	public empresa() {
		super();
	}
	public void Empresa(String nombre, String direccion, String telefono, String contacto) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	

}
