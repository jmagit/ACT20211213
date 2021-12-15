package com.example.domains.entities;

import org.springframework.stereotype.Component;

@Component
public class ProfesorImpl implements Persona, Profesor, Profe {

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Pepito";
	}

	@Override
	public String getApellidos() {
		// TODO Auto-generated method stub
		return "Grillo";
	}

	@Override
	public String getNombreCompleto() {
		return getApellidos() + ", " + getNombre() ;
	}

	@Override
	public String getAsignatura() {
		// TODO Auto-generated method stub
		return null;
	}

}
