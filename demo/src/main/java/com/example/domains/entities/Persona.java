package com.example.domains.entities;

public interface Persona {
	String getNombre();
	String getApellidos();
//	String getNombreCompleto();
	default String getOtro() {
		return getNombre() + ' ' + getApellidos();
	}
	
	default String getNombreCompleto() {
		return getNombre() + ' ' + getApellidos();
	}
}
