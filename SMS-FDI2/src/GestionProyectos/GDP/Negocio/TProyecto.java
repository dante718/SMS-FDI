package GestionProyectos.GDP.Negocio;

import java.util.List;

public class TProyecto{
      private String nombre, descripcion, mododefabricacion, version,fechadeversion;
      private List<String> participantes;
    
      public void updateFecha(String fecha) {
    	  this.fechadeversion=fecha;
      }
      public void updateFabricacion(String Fab) {
    	  this.mododefabricacion=Fab;
      }
      public void updateVersion(String version) {
    	  this.version=version;
      }
      public String leerNombre(){
    	  return nombre;
      }
      public String leerDescripcion(){
    	  return descripcion;
      }
      public List<String> leerparticipantes() {
    	  return participantes;
      }
      public int leerNparticipantes() {
    	  return participantes.size();
      }
      public String leerVersion() {
    	  return version;
      }
      public String leerFabricacion() {
    	  return mododefabricacion;
      }
      public String leerFecha() {
    	  return fechadeversion;
      }
	
		public TProyecto crearObjeto(List<Object> datos) {
				for(int i=0;i<datos.size();i++) {
					if(i==0) this.nombre=(String) datos.get(i);
					else if(i==1) this.descripcion=(String) datos.get(i);
					else if(i==2) this.version=(String) datos.get(i);
					else if(i==3) this.fechadeversion=(String) datos.get(i);
					else if(i==4) this.mododefabricacion=(String) datos.get(i);
					else if(i==5) this.participantes=(List<String>) datos.get(i);
				}
				return this;
		}
}
