package com.example;

import java.util.Optional;

public class Hijo extends Ejemplo {

	public Hijo(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}

//	public void noOverride() {
//		
//	}

	@Override
	public void otro() {
		// TODO Auto-generated method stub
		System.out.println("Soy el hijo");
		pon("Pepito", null);
		Hijo h = new Hijo(MAX);
		String n = h.getNombre();
		String a; //= h.getApellidos();
		if(h.getApellidos().isPresent())
			a = h.getApellidos().get();
		
	}
	private String nombre, apellidos;
	public void pon(String nombre, String apellidos) {
		assert nombre != null : "falta el nombre";
		assert apellidos != null : "falta los apellidos";
		
		if(nombre == null) 
			throw new IllegalArgumentException("el nombre es obligatorio");
		if(apellidos == null) 
			throw new IllegalArgumentException("los apellidos son obligatorios");
		// ...		
		
	}
	
	public void pon(String nombre) {
		if(nombre == null) 
			throw new IllegalArgumentException("el nombre es obligatorio");
// ...		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public Optional<String> getApellidos() {
//		if(apellidos == null)
//			return Optional.empty();
//		else
//			return Optional.of(apellidos);
		return Optional.ofNullable(apellidos);
	}
}
