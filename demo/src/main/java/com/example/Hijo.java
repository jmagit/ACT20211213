package com.example;

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
	}
}
