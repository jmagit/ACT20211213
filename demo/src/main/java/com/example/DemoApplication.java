package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String x = null;
		List<Integer> lst = new ArrayList<>();
		System.out.println(media(1, 2, 3));
		System.out.println(media(1, 2));
		System.out.println(media(1, 2, 3, 4));
		System.out.println(media(new double[] {1, 2, 3, 4}));
		var c = new Ejemplo(0);
		c.otro();
		c = new Hijo(0);
		c.otro();
		var f = new Factura();
		var ff = new Factura();
		var estado = f.getEstado();
		f.add(1, 1);
		var linea = f.get(0);
		ff.add(linea);
	}

	double media(double a, double b, double... valores) {
		var rslt = a + b;
		for(var v : valores) rslt += v;
		return rslt / (valores.length + 2);
	}
	double media(double[] valores) {
		final int id = valores.length == 0 ? 1 : (int)valores[valores.length - 1] + 1; 
		var rslt = 0.0;
		for(var v : valores) rslt += v;
		return rslt / (valores.length + 2);
	}
}