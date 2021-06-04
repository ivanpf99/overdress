package com.elorrieta.overdress.modelo;

public class Carta {

	private int id;
	private String numero_id;
	private String nombre;
	private Coleccion coleccion;
	private Tipo tipo;
	private Grado grado;
	private int copias;

	public Carta() {
		super();
		this.id = 0;
		this.numero_id = "";
		this.nombre = "";
		this.coleccion = new Coleccion();
		this.tipo = new Tipo();
		this.grado = new Grado();
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

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", numero_id=" + numero_id + ", nombre=" + nombre + ", coleccion=" + coleccion
				+ ", tipo=" + tipo + ", grado=" + grado + ", copias=" + copias + "]";
	}

}
