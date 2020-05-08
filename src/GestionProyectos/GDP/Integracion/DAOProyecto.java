package GestionProyectos.GDP.Integracion;

import java.util.List;

import GestionProyectos.GDP.Negocio.TProyecto;

public interface DAOProyecto {
      public List<TProyecto> leerProyectos();
      public void EscribirProyectos(List<TProyecto> proyectos);
}
