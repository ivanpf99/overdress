package com.elorrieta.overdress.modelo;

public class Grado {

	private int id;
	private String nombre;

	public Grado() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Grado [id=" + id + ", nombre=" + nombre + "]";
	}

}
