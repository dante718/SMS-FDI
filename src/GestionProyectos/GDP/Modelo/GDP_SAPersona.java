package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

public interface GDP_SAPersona {
     public void inidatos();
     public TableModel leerdatosini(String tipo);
	public int BuscarProyecto(String nombreProy);
	public void CrearProyecto(GDP_TProyecto proyecto,List<GDP_TPersona> participantes);
}