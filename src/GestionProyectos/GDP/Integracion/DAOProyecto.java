package GestionProyectos.GDP.Integracion;

import java.util.List;

import GestionProyectos.GDP.Negocio.TProyecto;

public interface DAOProyecto {
      public void leerProyectos();
      public void AddProyecto(TProyecto proyecto);
      public void EscribirProyectos();
      public boolean LiberarPersonadeProyecto(String DNI);
	  public ModeloTablaProyectos creartablaProyectos();
	  public boolean cambiarproyecto(String DNI, String NombreProy);
	  public void añadirpersona(String DNI, String NombreProy);
	  public TProyecto getProyecto(String NombreProy);
	  public void GenerarNuevaVersion(String NombreProy);
	  public boolean pasarafabricacion(String NombreProy);
	  public List<String> getParticipantesProyecto(String NombreProy);
	  public void ponerenfabricacion(String nombreProy);
}
