package com.elorrieta.overdress.modelo;

public class Carta {

	private int id;
	private String numero_id;
	private String nombre;
	private String coleccion;
	private String tipo;
	private int grado;
	private int copias;

	public Carta() {
		super();
		this.id = 0;
		this.numero_id = "";
		this.nombre = "";
		this.coleccion = "";
		this.tipo = "";
		this.grado = 0;
		this.copias = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero_id() {
		return numero_id;
	}

	public void setNumero_id(String numero_id) {
		this.numero_id = numero_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", numero_id=" + numero_id + ", nombre=" + nombre + ", coleccion=" + coleccion
				+ ", tipo=" + tipo + ", grado=" + grado + ", copias=" + copias + "]";
	}

}
