package GestionProyectos.GDP.Negocio;

import java.util.List;

public class TPersona {
      private String DNI, Nombre, Apellido1,Apellido2, Profesion,Estado,Rol;
    
      public String leerDNI() {
    	  return DNI;
      }
      public String leerNombre() {
    	  return Nombre;
      }
      public String leerApellido1() {
    	  return Apellido1;
      }
      public String leerApellido2() {
    	  return Apellido2;
      }
      public String leerProfesion() {
    	  return Profesion;
      }
      public String leerEstado() {
    	  return Estado;
      }
      public String leerRol() {
    	  return Rol;
      }
      public void updateEstado(String Estado) {
    	  this.Estado=Estado;
      }
         
	
      public TPersona crearObjeto(List<Object> datos) {
			for(int i=0;i<datos.size();i++) {
				if(i==0) this.DNI=(String) datos.get(i);
				else if(i==1) this.Nombre=(String) datos.get(i);
				else if(i==2) this.Apellido1=(String) datos.get(i);
				else if(i==3) this.Apellido2=(String) datos.get(i);
				else if(i==4) this.Profesion=(String) datos.get(i);
				else if(i==5) this.Estado=(String) datos.get(i);
				else if(i==6) this.Rol=(String) datos.get(i);
			}
			return this;
	}
}
