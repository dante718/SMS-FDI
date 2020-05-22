package GestionDeInformatica.GDI.Modelo;

import java.util.List;

import GestionProyectos.GDP.Negocio.TPersona;

public class TransferEmpleados {
  
	//Propiedades
	private String DNI;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String Profesion;
	private String Estado;
	private String Rol;
	
	//constructor
	public TransferEmpleados(String dni, String nom,String ap1,String ap2,String prof,String est,String ro) {
		DNI=dni;
		Nombre=nom;
		Apellido1=ap1;
		Apellido2=ap2;
		Profesion=prof;
		Estado=est;
		Rol=ro;
	}
	
	//Metodos - getters&setters
	
	public void setDni(String dni) {
		DNI=dni;
	}
	public String getDni() {
		return DNI;
	}
	public void setName(String nom) {
		Nombre=nom;
	}
	public String getName() {
		return Nombre;
	}
	public void setAp1(String ap1) {
		Apellido1=ap1;
	}
	public String getAp1() {
		return Apellido1;
	}
	public void setAp2(String ap2) {
		Apellido2=ap2;
	}
	public String getAp2() {
		return Apellido2;
	}
	public void setProf(String prof) {
		Profesion=prof;
	}
	public String getProf() {
		return Profesion;
	}
	public void setEst(String est) {
		Estado=est;
	}
	public String getEst() {
		return Estado;
	}
	public void setRo(String ro) {
		Rol=ro;
	}
	public String getRo() {
		return Rol;
	}
	

	
}
