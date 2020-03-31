package GestionDeProyectos;

import java.util.ArrayList;
import java.util.List;

public class GDP_TProyecto {
      private String nombre, descripcion;
      private int nparticipantes;
      public GDP_TProyecto(String nombre, String descripcion, int nparticipantes) {
    	  this.nombre=nombre;
    	  this.descripcion=descripcion;
    	  this.nparticipantes=nparticipantes;
      }
      public String getNombre(){
    	  return nombre;
      }
      public String getDescripcion(){
    	  return descripcion;
      }
      public int getNparticipantes() {
    	  return nparticipantes;
      }
}
