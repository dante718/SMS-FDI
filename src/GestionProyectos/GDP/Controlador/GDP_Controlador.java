package GestionProyectos.GDP.Controlador;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import GestionProyectos.GDP.Modelo.GDP_ModeloTabla;
import GestionProyectos.GDP.Modelo.GDP_SAPersona;
import GestionProyectos.GDP.Modelo.GDP_SAPersonaImp;
import GestionProyectos.GDP.Modelo.GDP_TPersona;
import GestionProyectos.GDP.Modelo.GDP_TProyecto;
import GestionProyectos.GDP.Modelo.GDP_TableModel;

public class GDP_Controlador {
     private GDP_SAPersona SA;
	
	public GDP_Controlador() {
		SA= new GDP_SAPersonaImp();
		leerdatos();
	}
	public GDP_ModeloTabla creartabla(String tipo) {
	 if(!tipo.toLowerCase().contentEquals("investigador") && !tipo.toLowerCase().contentEquals("trabajador")) {
		 JOptionPane.showMessageDialog(null, "El rol de persona no es valido");
		 return null;
	 }
	 else {
		 GDP_ModeloTabla Ta= SA.creartabla(tipo);
		  if(Ta!=null) {
			  return Ta;
		  }
		  return null;		
		}
	 }
	
	public boolean AddProyecto(GDP_TProyecto proyecto) {
		int ret= BuscarProyecto(proyecto.getNombre());
		if(ret==-1) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else if(ret==1) {
			SA.AddProyecto(proyecto); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
		else return false;
	}
	public int BuscarProyecto(String NombreProy) {
		int ret= SA.BuscarProyecto(NombreProy);
		return ret;
	}
	public void leerdatos() {
		SA.leerdatos();
	}
	public void liberar(String DNI) {
		SA.liberar(DNI);
	}
}
