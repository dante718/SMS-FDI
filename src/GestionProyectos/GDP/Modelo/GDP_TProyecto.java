package GestionProyectos.GDP.Modelo;

import java.util.ArrayList;
import java.util.List;

public class GDP_TProyecto {
      private String nombre, descripcion;
      private List<String> participantes;
      public GDP_TProyecto(String nombre, String descripcion, List<String> participantes) {
    	  this.nombre=nombre;
    	  this.descripcion=descripcion;
    	  this.participantes=participantes;
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
}
