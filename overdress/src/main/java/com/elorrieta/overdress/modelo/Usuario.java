package com.elorrieta.overdress.modelo;

public class Usuario {

	public static final int ROL_USUARIO = 1;
	public static final int ROL_ADMIN = 2;

	private int id;
	private String nombre;
	private String pass;
	private int rol;

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.pass = "";
		this.rol = ROL_USUARIO;
	}

	public Usuario(int id, String nombre, String pass, int rol) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.rol = rol;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", rol=" + rol + "]";
	}

}
