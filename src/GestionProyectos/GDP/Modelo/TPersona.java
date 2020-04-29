package GestionProyectos.GDP.Modelo;

public class TPersona {
      private String DNI, Nombre, Apellido1,Apellido2, Profesion,Estado,Rol;
      public TPersona(String DNI, String Nombre, String Apellido1, String Apellido2, String Profesion, String Estado, String Rol) {
    	  this.DNI=DNI;
    	  this.Nombre=Nombre;
    	  this.Apellido1=Apellido1;
    	  this.Apellido2=Apellido2;
    	  this.Profesion=Profesion;
    	  this.Estado=Estado;
    	  if(Rol.toLowerCase().equals("investigador") || Rol.toLowerCase().equals("trabajador")) {
    		  this.Rol=Rol;
    	  }
    	  else throw new IllegalArgumentException("Su rol no está entre las opciones posible, ha de ser investigador o trabajador");
      }
      public String getDNI() {
    	  return DNI;
      }
      public String getNombre() {
    	  return Nombre;
      }
      public String getApellido1() {
    	  return Apellido1;
      }
      public String getApellido2() {
    	  return Apellido2;
      }
      public String getProfesion() {
    	  return Profesion;
      }
      public String getEstado() {
    	  return Estado;
      }
      public String getRol() {
    	  return Rol;
      }
      public void setEstado(String Estado) {
    	  this.Estado=Estado;
      }
}
