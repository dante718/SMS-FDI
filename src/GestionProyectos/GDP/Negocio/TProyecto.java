package GestionProyectos.GDP.Negocio;

import java.util.List;

public class TProyecto implements ITransfer<TProyecto>{
      private String nombre, descripcion, mododefabricacion, version,fechadeversion;
      private List<String> participantes;
    
      public void setFecha(String fecha) {
    	  this.fechadeversion=fecha;
      }
      public void setFabricacion(String Fab) {
    	  this.mododefabricacion=Fab;
      }
      public void setVersion(String version) {
    	  this.version=version;
      }
      public String getNombre(){
    	  return nombre;
      }
      public String getDescripcion(){
    	  return descripcion;
      }
      public List<String> getparticipantes() {
    	  return participantes;
      }
      public int getNparticipantes() {
    	  return participantes.size();
      }
      public String getVersion() {
    	  return version;
      }
      public String getFabricacion() {
    	  return mododefabricacion;
      }
      public String getFecha() {
    	  return fechadeversion;
      }
	@SuppressWarnings("unchecked")
	@Override
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
