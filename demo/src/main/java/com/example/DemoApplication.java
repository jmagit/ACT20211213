package com.example;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.OperationNotSupportedException;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Ejemplo.a;
import com.example.domains.entities.Alumno;
import com.example.domains.entities.AlumnoImpl;
import com.example.domains.entities.Autor;
import com.example.domains.entities.Empleado;
import com.example.domains.entities.EntidadBase;
import com.example.domains.entities.Factura;
import com.example.domains.entities.Persona;
import com.example.domains.entities.Profe;
import com.example.domains.entities.Profesor;
import com.example.domains.entities.ProfesorImpl;
import com.example.exceptions.CursoException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Autowired
//	Profesor profe;
	
	@Override
	public void run(String... args) throws Exception {
		List<Persona> lista = List.of(
				new AlumnoImpl(1, "Pepito", "Grillo", LocalDate.of(2000, 10, 10), 9.0),
				new ProfesorImpl(2, "Profe", "Grillo", LocalDate.of(2002, 6, 1), "Java"),
				new ProfesorImpl(3, "Otro", "Profe", LocalDate.of(1985, 1, 1), "Testing"),
				new AlumnoImpl(4, "Pedro", "Pica Piedra", LocalDate.of(2003, 7, 30), 4.0),
				new AlumnoImpl(5, "Pablo", "Marmol", LocalDate.of(2000, 2, 28), 7.0),
				new AlumnoImpl(6, "Inigo", "Gosson", LocalDate.of(2003, 7, 3), 4.9),
				new AlumnoImpl(7, "Omero", "Berndsen", LocalDate.of(2000, 3, 24), 6.8),
				new AlumnoImpl(8, "Rafa", "Neilus", LocalDate.of(2001, 5, 28), 5.0),
				new AlumnoImpl(9, "Bea", "Gieves", LocalDate.of(2002, 7, 7), 7.0),
				new AlumnoImpl(10, "Giacomo", "Rosindill", LocalDate.of(2003, 12, 30), 6.0),
				new AlumnoImpl(11, "Gracia", "Shipton", LocalDate.of(2001, 1, 4), 6.0),
				new AlumnoImpl(12, "Herminia", "Carpe", LocalDate.of(2004, 12, 30), 8.0)
				);

//		if(lista.stream().filter(item -> item instanceof Alumno).allMatch(item -> ((Alumno)item).getNota() > 5.0)) {
//			System.out.println("No hay suspenso");
//		}
//		if(lista.stream().filter(item -> item instanceof Alumno).anyMatch(item -> ((Alumno)item).getNota() < 5.0)) {
//			System.out.println("Hay suspensos");
//		}
//		var a = lista.stream().filter(item -> item instanceof Alumno).filter(item -> ((Alumno)item).getNota() < 5.0).findAny();
//		System.out.println(a);
		
		var a = new AlumnoImpl(1, "kk", "Gssssssssssssssssss", LocalDate.of(2030, 10, 10), 9.0);
		if(a.isValid()) {
			System.out.println(a);
		} else {
			System.out.println(a.getErrorsMessage());
		}
		
//		var a =	new AlumnoImpl(1, "Pepito", "Grillo", LocalDate.of(2000, 10, 10), 9.0);
//		var p = new ProfesorImpl(1, "Profe", "Grillo", LocalDate.of(2002, 6, 1), "Java");
//		if(a.equals(p))
//			System.out.println("son iguales");
//		if(a.hashCode() == p.hashCode())
//			System.out.println("son iguales por hash");
//		if(a.compareTo(p) == 0)
//			System.out.println("son iguales por compared");
		
//		lista.stream()
//			.filter(item -> item instanceof Profesor)
//			.map(item -> (Profesor)item)
//			.forEach(item -> System.out.println(item.getApellidos() + ", " + item.getAsignatura()));
//		var p = lista.stream()
//			.filter(item -> item instanceof Profesor)
//			.map(item -> (Profesor)item)
//			.sorted()
//			.findFirst();
//		if(p.isPresent())
//			System.out.println(p.get());
//		
//		var l = lista.stream()
//			.filter(item -> item instanceof Profesor)
//			.map(item -> (Profesor)item)
//			.sorted((a, b) -> a.getAsignatura().compareTo(b.getAsignatura()))
//			.collect(Collectors.toList());
//		// ...
//		l.forEach(System.out::println);
//		var sum = 
//			lista.stream()
//			.filter(item -> item.getNombre().startsWith("P"))
//			.mapToInt(item -> {
//				try {
//					return item.getEdad();
//				} catch (OperationNotSupportedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return 0;
//				}
//			})
//			.sum();
//		var sum = 
//				lista.stream()
//				.filter(item -> item.getNombre().startsWith("P"))
//				.map(item -> {
//					try {
//						return item.getEdad();
//					} catch (OperationNotSupportedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						return 0;
//					}
//				})
//				.reduce(0, (a, item) -> a + item);
//		
//		System.out.println(sum);
//		lista.stream()
//		.filter(item -> item.getNombre().startsWith("P"))
//		.forEach(item -> {
//			try {
//				System.out.println(item.getNombre() + " " + item.getEdad());
//			} catch (OperationNotSupportedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		
//			.forEach(this::pinta);
//		.forEach(DemoApplication::pinta); -> item.pinta()
//		.forEach(System.out::println);
		
		boolean soloAlumno = true, paginado = true;
		int pagina = 0, fila = 3;
		
//		var consulta = lista.parallelStream();
//		if(soloAlumno)
//			consulta = consulta
//				.filter(item -> item instanceof Alumno)
//				.map(item -> (Alumno)item )
//				.peek(item -> item.setNota(item.getNota() * 1.1))
//				.map(item -> (Persona)item);
//		if(paginado)
//			consulta = consulta.sequential().sorted().skip(pagina * fila).limit(fila);
//		// ...
//		
//		consulta.forEach(System.out::println);
		//lista.forEach(System.out::println);
//		List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		System.out.println("Sequential Stream: ");
//		listOfIntegers.stream().sorted((a,b) -> b-a).forEach(e -> System.out.print(e + " "));
//		System.out.println("\nParallel Stream: ");
//		listOfIntegers.stream().parallel().sequential().sorted((a,b) -> b-a).forEach(e -> System.out.print(e + " "));

	}
	public void pinta(Object item) {
		System.out.println(item);
	}
	record Reg(int key, String value) { }
 
	class RegImpl {
		public final int key;
		public final String value;
		
		public RegImpl(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int Key() {
			return key;
		}

		public String Value() {
			return value;
		}
		
	}
	public void run1(String... args) throws Exception {
		Reg reg = new Reg(0, "Algo");
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
//		Elemento<? extends Persona, String> empleado = new Elemento<Empleado, String>((Empleado)null, "Madrid");
		var rslt = primitivo.conv("Str", AlumnoImpl.class);
		if(primitivo instanceof Elemento) {
			
		}
	}
	
	void kk(Elemento<? extends Persona, String> primitivo) {
		primitivo.getKey().getApellidos();
	}
	public void run2(String... args) throws Exception {
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
			f.getErrors().forEach(item -> System.out.println(item.getPropertyPath() + ": " + item.getMessage()));
		
		var anotaciones = f.getClass().getAnnotations();
		for(var a: anotaciones)
			System.out.println(a.annotationType().getName());
			
		if(f.getClass().getAnnotation(Autor.class) != null)
			System.out.println(f.getClass().getAnnotation(Autor.class).nombre());
		if(f.isInvalid())
			f.getErrors().forEach(this::pinta);
	}
	
	public void pinta(ConstraintViolation<EntidadBase<Factura>> item) {
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
