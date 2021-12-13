package com.example;

import java.util.ArrayList;
import java.util.List;

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
	
	interface Grafico {
		void pinta();
	}
	public void name(int param) {
		var s = "Hola mundo ";
		class DeMetodo implements Grafico {
			public int name() {
				return param;
			}

			@Override
			public void pinta() {
				System.out.println(s + param);
			}
		}
		
		var m = new DeMetodo();
		m.pinta();
//		while(true) {
//			var a = param;
//			while (true) {
//				var b = m;
//				a++;				
//			}
//		}
	}

	public static enum Tipo {
		Binaria, Textual, BinariaDesc, TextualDesc
	}
	
	@FunctionalInterface
	interface Comparador {
		int compara(String a, String b);
		default boolean esMayor(String a, String b) {
			return compara(a, b) > 0;
		}
		default boolean esIgual(String a, String b) {
			return compara(a, b) == 0;
		}
	}
	
	class ComparacionBinaria implements Comparador {
		@Override
		public int compara(String a, String b) {
			return a.compareTo(b);
		}
	}
	class ComparacionTextual implements Comparador {
		@Override
		public int compara(String a, String b) {
			return a.compareToIgnoreCase(b);
		}
	}

	public void ejecutar() {
		class Comparacion implements Comparador {
			@Override
			public int compara(String a, String b) {
				return -a.compareTo(b);
			}
		}

		List<String> lst = new ArrayList<String>();
		ordenar(lst, new ComparacionBinaria());
		ordenar(lst, new ComparacionTextual());
		ordenar(lst, new Comparacion());
		ordenar(lst, new Comparador() {
			@Override
			public int compara(String a, String b) {
				return a.substring(0, 3).compareTo(b.substring(0, 3));
			}
			@Override
			public boolean esMayor(String a, String b) {
				return compara(a, b) < 0;
			};
		}
		);
		Comparador comparador = (a, b) -> -a.compareTo(b);
		if(comparador.esMayor("", "")) {
			
		}
		ordenar(lst, (x, y) -> { 
			var rslt = x.substring(0, 3).compareTo(y.substring(0, 3));
			// ...
			return rslt;
			});
		ordenar(lst, comparador);
		
//		ordenar(lst, Tipo.Binaria);
//		ordenar(lst, Tipo.Textual);
//		ordenar(lst);
//		ordenarSinMayusculas(lst);
	}
	
	void ordenar(List<String> lst, Comparador comparador) {
		String a = "", b = "";
		// ...
		if(comparador.compara(a, b) < 0) {
		
		} else if(comparador.compara(a, b) == 0) {
			
		} else { // a > b
			
		}
		// ...
	}

//	void ordenar(List<String> lst, Tipo tipo) {
//		String a = "", b = "";
//		// ...
//		switch (tipo) {
//		case Binaria: {
//				if(a.compareTo(b) < 0) {
//					
//				} else if(a.compareTo(b) == 0) {
//					
//				} else { // a > b
//					
//				}
//			}
//		case Textual: {
//			if(a.compareToIgnoreCase(b) < 0) {
//				
//			} else if(a.compareToIgnoreCase(b) == 0) {
//				
//			} else { // a > b
//				
//			}
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + tipo);
//		}
//		// ...
//	}

//	void ordenar(List<String> lst) {
//		String a = "", b = "";
//		// ...
//		if(a.compareTo(b) < 0) {
//			
//		} else if(a.compareTo(b) == 0) {
//			
//		} else { // a > b
//			
//		}
//		// ...
//	}
//	
//	void ordenarSinMayusculas(List<String> lst) {
//		String a = "", b = "";
//		// ...
//		if(a.compareToIgnoreCase(b) < 0) {
//			
//		} else if(a.compareToIgnoreCase(b) == 0) {
//			
//		} else { // a > b
//			
//		}
//		// ...
//	}
}
