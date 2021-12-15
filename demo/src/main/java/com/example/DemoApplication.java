package com.example;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.entities.Autor;
import com.example.domains.entities.Empleado;
import com.example.domains.entities.Entidad;
import com.example.domains.entities.Factura;
import com.example.domains.entities.Persona;
import com.example.domains.entities.Profe;
import com.example.domains.entities.Profesor;
import com.example.domains.entities.ProfesorImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	Profe profe;
	
	public void run1(String... args) throws Exception {
		Elementos.ElementoObject[] provincias = new Elementos.ElementoObject[10];
		
		provincias[0] = new Elementos.ElementoObject(28, "Madrid");
		provincias[1] = new Elementos.ElementoObject("MAD", "Madrid");
		provincias[3] = new Elementos.ElementoObject(2.8, "Madrid");
		Elemento<Integer, String> provincia = new Elemento<>(28, "Madrid");
		Elemento<Character, String> genero = new Elemento<>('H', "Hombre");
//		provincia = new Elemento<>("MAD", "Madrid");
//		System.out.println(provincia.getKey());
//		provincia.setKey("kk");
		Elemento<Character, Empleado> generos[] = new Elemento[10];
		Elemento<? extends Persona, String> primitivo = new Elemento<Persona, String>((Persona)null, "Madrid");
		var s = Ejemplo.generico("Hola");
		var o = Ejemplo.sintipo("Hola", Integer.class);
		var p = new Elemento<ProfesorImpl, String>(ProfesorImpl.class, "Madrid");
		Elemento<? extends Persona, String> persona = new Elemento<Persona, String>((Persona)null, "Madrid");
		Elemento<? extends Persona, String> empleado = new Elemento<Empleado, String>((Empleado)null, "Madrid");
	}
	
	void kk(Elemento<? extends Persona, String> primitivo) {
		primitivo.getKey().getApellidos();
	}
	@Override
	public void run(String... args) throws Exception {
//		String x = null;
//		List<Integer> lst = new ArrayList<>();
//		System.out.println(media(1, 2, 3));
//		System.out.println(media(1, 2));
//		System.out.println(media(1, 2, 3, 4));
//		System.out.println(media(new double[] {1, 2, 3, 4}));
		var c = new Ejemplo(0);
		c.name(4);
		c.name(5);
		Class tipo = c.getClass();
		var fld = tipo.getDeclaredField("privado");
		fld.setAccessible(true);
//		System.out.println(c.privado);
		System.out.println(fld.get(c));
		fld.set(c, "Esto es publico");
//		fld.set(c, null);
		System.out.println(fld.get(c));
		String cmd = "otro";
		tipo.getMethod(cmd).invoke(c);
		for(var m : tipo.getMethods())
			System.out.println(m.getName());
		String clase = "com.example.domains.entities.ProfesorImpl";
		Class nuevo = Class.forName(clase);
		Object object = nuevo.getConstructors()[0].newInstance();
		System.out.println(object);
		for(var m : nuevo.getMethods()) {
			//System.out.println(m.getName());
			if(m.getName().startsWith("get"))
				System.out.println(m.invoke(object));
		}
//		tipo.getMethod("name").invoke(c, 666);
//		c.otro();
//		c = new Hijo(0);
//		c.otro();
//		var f = new Factura(111);
//		var ff = new Factura(2);
//		var estado = f.getEstado();
//		f.add(1, 1);
//		f.add(2, 2);
//		var linea = f.get(0);
////		linea = new f.Linea(0, 0);
////		System.out.println(linea.getNumFactura());
////		ff.add(linea);
//		System.out.println(linea.getNumFactura());
//		System.out.println(f.get(1).getNumFactura());
//		f.setNumFactura(222);
//		System.out.println(linea.getNumFactura());
//		System.out.println(f.get(1).getNumFactura());
//		Profesor p = new ProfesorImpl();
//		System.out.println(p.getNombreCompleto());
		var f = new Factura(-5);
		if(f.isInvalid())
			f.getErros().forEach(item -> System.out.println(item.getPropertyPath() + ": " + item.getMessage()));
		
		var anotaciones = f.getClass().getAnnotations();
		for(var a: anotaciones)
			System.out.println(a.annotationType().getName());
			
		if(f.getClass().getAnnotation(Autor.class) != null)
			System.out.println(f.getClass().getAnnotation(Autor.class).nombre());
		if(f.isInvalid())
			f.getErros().forEach(this::pinta);
	}
	
	public void pinta(ConstraintViolation<Entidad<Factura>> item) {
		System.out.println(item.getPropertyPath() + ": " + item.getMessage());
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
