package com.example;


public class Ejemplo {
	public static final int MIN;
	
	static {
		MIN = 0;
	}
	
	public final int MAX;
	
	public Ejemplo(int max) {
		MAX = max;
	}
	
	public final void noOverride() {
		
	}
	public void otro() {
		System.out.println("Soy el padre");
		
	}

}
