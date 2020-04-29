package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

public interface SA {
     public void leerdatos();
     public ModeloTablaPersona creartablaPersonas(String tipo);
	 public int BuscarProyecto(String nombreProy);
	 public boolean liberar(String DNI);
	 public void AddProyecto(TProyecto proyecto);
	 public ModeloTablaProyectos creartablaProyectos();
}
