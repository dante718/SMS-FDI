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
	 if(!tipo.toLowerCase().contentEquals("investigador") && !tipo.toLowerCase().contentEquals("trabajador") && !tipo.toLowerCase().contentEquals("participantes")) {
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
		
		if(BuscarProyecto(proyecto.getNombre())) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else {
			sa.AddProyecto(proyecto); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
	}
	public boolean BuscarProyecto(String NombreProy) {
		return sa.BuscarProyecto(NombreProy);
	}
	public void leerdatos() {
		sa.leerdatos();
	}
	public boolean liberar(String DNI) {
		return sa.liberar(DNI);
	}
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		return sa.cambiarproyecto(DNI, NombreProy);
	}
	public void añadiraproyecto(String DNI, String NombreProy) {
		sa.añadiraproyecto(DNI, NombreProy);
	}
	public boolean compararfechas(String fechaAntigua) {
		return sa.compararfechas(fechaAntigua);
	}
	public void GenerarNuevaVersion(String NombreProy) {
		sa.GenerarNuevaVersion(NombreProy);
	}
	public boolean pasarafabricacion(String NombreProy) {
		return sa.pasarafabricacion(NombreProy);
	}
	public ModeloTablaPersona tablapersonaldeproyecto(String NombreProy) {
		return sa.tablapersonaldeproyecto(NombreProy);
	}
	public void ponerenfabricacion(String nombreProy) {
		
		sa.ponerenfabricacion(nombreProy);
	}
}
