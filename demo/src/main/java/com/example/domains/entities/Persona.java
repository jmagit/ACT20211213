package com.example.domains.entities;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

public interface Persona extends Comparable<Persona>, Entidad<Persona> {
	int getId();
	String getNombre();
	String getApellidos();
	LocalDate getFechaNacimiento();
	int getEdad() throws OperationNotSupportedException;	
	
//	String getNombreCompleto();
	default String getOtro() {
		return getApellidos() + ", " + getNombre();
	}
	
	default String getNombreCompleto() {
		return getNombre() + " " + getApellidos();
	}
}
