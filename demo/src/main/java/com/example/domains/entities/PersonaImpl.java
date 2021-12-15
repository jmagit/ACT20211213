package com.example.domains.entities;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

public class PersonaImpl implements Persona {
	private int id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	transient private int edad;
	
	public PersonaImpl(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		if(fechaNacimiento != null)
			setFechaNacimiento(fechaNacimiento); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		assert fechaNacimiento != null : "Fecha a nulo";
//		assert fechaNacimiento.isBefore(LocalDate.now()) : "Fecha posterior";
		this.fechaNacimiento = fechaNacimiento;
		edad = LocalDate.now().getYear() - fechaNacimiento.getYear() - 
				(LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear() ? 1 : 0);
		assert edad >= 0 : "Edad negativa";
	}
	
	public int getEdad() throws OperationNotSupportedException {
		if(fechaNacimiento == null)
			throw new OperationNotSupportedException();
		return edad;
//		return LocalDate.now().getYear() - fechaNacimiento.getYear() - 
//				(LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear() ? 1 : 0);
	}

}
