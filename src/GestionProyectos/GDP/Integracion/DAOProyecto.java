package GestionProyectos.GDP.Integracion;

import java.util.List;

import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;

public interface DAOProyecto {
      public void leerProyectos();
      public void EscribirProyectos();
      public TProyecto getProyecto(TProyecto Proyecto);
      public boolean LiberarPersonaDeProyecto(TPersona persona);
      public boolean cambiarproyecto(TPersona Persona, TProyecto proyecto);
      public void AddProyecto(TProyecto proyecto);
      public ModeloTablaProyectos creartablaProyectos();
      public void annadiraproyecto(TPersona persona, TProyecto proyecto);
      public void GenerarNuevaVersion(TProyecto proyecto);
      public boolean pasarafabricacion(TProyecto proyecto);
      public void ponerenfabricacion(TProyecto proyecto);
      public int getTamProyectos();
}
