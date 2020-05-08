package GestionProyectos.GDP.Integracion;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;

public interface DAOPersona {
      public List<TPersona> leerPersonas();
	  public void EscribirPersonas(List<TPersona> personas);	 
}
