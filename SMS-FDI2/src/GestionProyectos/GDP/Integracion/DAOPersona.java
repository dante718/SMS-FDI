package GestionProyectos.GDP.Integracion;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;

public interface DAOPersona {
      public void leerPersonas();
	  public void EscribirPersonas();
	  public TPersona getPersona(TPersona Persona);
	  public ModeloTablaPersona creartablaPersonas(String RolPersona);
	  public void liberar(TPersona persona);
	  public void AddProyecto(TProyecto proyecto);
	  public void annadiraproyecto(TPersona persona);
	  public ModeloTablaPersona tablapersonaldeproyecto(TProyecto proyecto);
	  public int getTamPersonas();
}
