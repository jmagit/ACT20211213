package com.example.domains.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NonNull;

@Data
@Autor(nombre = "Javier")
public class Factura extends Entidad<Factura> {
	public static enum Estado {
		pendiente(0), pagada(1), cancelada(2);

		private int value;
		Estado(int i) {
			value = 1;
		}
		public int getValue() { return value; }
		public static Estado getEnum(int i) {
			switch (i) {
			case 0: return pendiente;
			case 1: return pagada;
			case 2: return cancelada;
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		}
	}
	private Estado estado = Estado.pendiente;
	
	public class Linea {
		private int cantidad;
		private double precio;
//		private int numFactura;
//		private Factura factura;
		
		public Linea(int cantidad, double precio) {
			this.cantidad = cantidad;
			this.precio = precio;
		}
//		public Linea(int numFactura, int cantidad, double precio) {
//			this.numFactura = numFactura;
//			this.cantidad = cantidad;
//			this.precio = precio;
//		}
//		public Linea(Factura factura, int cantidad, double precio) {
//			this.factura = factura;
//			this.cantidad = cantidad;
//			this.precio = precio;
//		}
		
		public int getNumFactura() {
//			return factura.numFactura;
			return numFactura;
		}
	}
	
	@NonNull
	@Positive
	private int numFactura;
	@PastOrPresent
	private Date fecha;
	@Length(max = 100)
	@NotBlank
	private String nombre;
	
	private List<Linea> lineas = new ArrayList<Factura.Linea>();

	public Factura(int numFactura) {
		this.numFactura = numFactura;
		estado = Estado.getEnum(0);
	}
	
	public void add(int cantidad, double precio) {
		lineas.add(new Linea(cantidad, precio));		
//		lineas.add(new Linea(this.numFactura, cantidad, precio));		
//		lineas.add(new Linea(this, cantidad, precio));		
	}
	
	public void add(Linea linea) {
//		linea.numFactura = this.numFactura;
//		linea.factura.lineas.remove(linea);
//		linea.factura = this;
		lineas.add(linea);		
	}
	
	public Linea get(int index) {
		return lineas.get(index);		
	}
	@Override
	public String toString() {
		
		return "" + estado.getValue();
	}
	public int getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
//		lineas.forEach(item -> item.setNumFactura(numFactura));
	}
	
	public Estado getEstado() { return estado; }
}
