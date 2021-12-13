package com.example;

public enum EstadoFactura {
	pendiente (0), pagada(1), cancelada(2);

	private int value;
	EstadoFactura(int i) {
		value = 1;
	}
	public int getValue() { return value; }
	public static EstadoFactura getEnum(int i) {
		switch (i) {
		case 0: return pendiente;
		case 1: return pagada;
		case 2: return cancelada;
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
	}
}
