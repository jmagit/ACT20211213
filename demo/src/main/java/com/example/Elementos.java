package com.example;

public class Elementos {
	public static class Elemento<K> {
		private K key;
		private String value;
		public Elemento(K key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class ElementoObject {
		private Object key;
		private String value;
		public ElementoObject(Object key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public Object getKey() {
			return key;
		}
		public void setKey(Object key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class ElementoInteger {
		private int key;
		private String value;
		public ElementoInteger(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	public static class ElementoChar {
		private char key;
		private String value;
		public ElementoChar(char key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public char getKey() {
			return key;
		}
		public void setKey(char key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	public static class ElementoString {
		private String key;
		private String value;
		public ElementoString(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
