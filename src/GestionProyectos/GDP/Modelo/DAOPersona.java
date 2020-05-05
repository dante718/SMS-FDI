package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

public interface DAOPersona {
      public void leerPersonas();
      public TPersona getPersona(String DNI);
      public ModeloTablaPersona creartablaPersonas();
	  public void LiberarPersonadeProyecto(String DNI);
	  public void AddProyecto(TProyecto proyecto);
	  public void EscribirPersonas();
	  public ModeloTablaPersona creartablapersonaldeproyecto(List<String> DNIs);
}
