package GestionProyectos.GDP.Negocio;

import java.util.List;

public class TPersona implements ITransfer<TPersona>{
      private String DNI, Nombre, Apellido1,Apellido2, Profesion,Estado,Rol;
    
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
	@Override
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
