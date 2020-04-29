package GestionProyectos.GDP.Controlador;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import GestionProyectos.GDP.Modelo.ModeloTablaPersona;
import GestionProyectos.GDP.Modelo.ModeloTablaProyectos;
import GestionProyectos.GDP.Modelo.SA;
import GestionProyectos.GDP.Modelo.SAImp;
import GestionProyectos.GDP.Modelo.TProyecto;



public class Controlador {
     private SA sa;
	public Controlador() {
		sa= new SAImp();
		leerdatos();
	}
	public ModeloTablaPersona creartablaPersonas(String tipo) {
	 if(!tipo.toLowerCase().contentEquals("investigador") && !tipo.toLowerCase().contentEquals("trabajador")) {
		 JOptionPane.showMessageDialog(null, "El rol de persona no es valido");
		 return null;
	 }
	 else {
		 ModeloTablaPersona Ta= sa.creartablaPersonas(tipo);
		  if(Ta!=null) {
			  return Ta;
		  }
		  return null;		
		}
	 }
	public ModeloTablaProyectos crearTablaProyectos() {
		ModeloTablaProyectos Tp= sa.creartablaProyectos();
		return Tp;
	}
	public boolean AddProyecto(TProyecto proyecto) {
		int ret= BuscarProyecto(proyecto.getNombre());
		if(ret==-1) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else if(ret==1) {
			sa.AddProyecto(proyecto); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
		else return false;
	}
	public int BuscarProyecto(String NombreProy) {
		int ret= sa.BuscarProyecto(NombreProy);
		return ret;
	}
	public void leerdatos() {
		sa.leerdatos();
	}
	public boolean liberar(String DNI) {
		return sa.liberar(DNI);
	}
}
