package com.example.domains.entities;

public class ProfesorImpl implements Persona, Profesor {

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApellidos() {
		// TODO Auto-generated method stub
		return null;
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
