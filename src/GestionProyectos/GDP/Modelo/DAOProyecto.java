package GestionProyectos.GDP.Modelo;

public interface DAOProyecto {
      public void leerProyectos();
      public int BuscarProyecto(String Nombre);
      public void AddProyecto(TProyecto proyecto);
      public void EscribirProyectos();
      public boolean LiberarPersonadeProyecto(String DNI);
	  public ModeloTablaProyectos creartablaProyectos();
}
