package com.example;

import java.lang.reflect.InvocationTargetException;

public class Elemento<K, V> {
	private K key;
	private V value;
	
	public Elemento(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public Elemento(Class<K> tipo, V value) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		this.key = (K)tipo.getConstructors()[0].newInstance();
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		if(value instanceof String s)
			return (V)s.toUpperCase();
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
//	
//	void dame(K item) {
//		
//	}
//	
//	void dame(V item) {
//		
//	}
}
