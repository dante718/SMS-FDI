package GestionProyectos.GDP.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TProyecto {
      private String nombre, descripcion, mododefabricacion, version,fechadeversion;
      private List<String> participantes;
      public TProyecto(String nombre, String descripcion, List<String> participantes, String version, String fechadeversion, String MododeFabricacion) {
    	  this.nombre=nombre;
    	  this.descripcion=descripcion;
    	  this.participantes=participantes;
    	  this.mododefabricacion=MododeFabricacion;
    	  this.fechadeversion=fechadeversion;
    	  this.version=version;
      }
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
}
