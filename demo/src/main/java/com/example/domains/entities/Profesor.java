package com.example.domains.entities;

public interface Profesor {
	String getAsignatura();

//	String getNombreCompleto();
	
	default String getNombreCompleto() {
		return "El profe de " + getAsignatura();
	}
}
