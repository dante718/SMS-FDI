package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

public interface GDP_SAPersona {
     public void leerdatos();
     public GDP_ModeloTabla creartabla(String tipo);
	public int BuscarProyecto(String nombreProy);
	public void liberar(String DNI);
	public void AddProyecto(GDP_TProyecto proyecto);
}
