package GestionDeProyectos;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class GDP_Controlador {
     private GDP_SAPersona SA;
	
	public GDP_Controlador() {
		SA= new GDP_SAPersonaImp();
		inidatos();
	}
	public TableModel iniciarBasedeDatos(String tipo) {
	 if(!tipo.toLowerCase().contentEquals("investigador") && !tipo.toLowerCase().contentEquals("trabajador")) {
		 JOptionPane.showMessageDialog(null, "El rol de persona no es valido");
		 return null;
	 }
	 else {
		  TableModel Ta=SA.leerdatosini(tipo);
		  if(Ta!=null) {
			  return Ta;
		  }
		  return null;		
		}
	 }
	
	public boolean CrearProyecto(GDP_TProyecto proyecto,List<GDP_TPersona> participantes) {
		int ret= BuscarProyecto(proyecto.getNombre());
		if(ret==-1) {
			JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo nombre");
			return false;
		}
		else if(ret==1) {
			SA.CrearProyecto(proyecto,participantes); 
			JOptionPane.showMessageDialog(null, "Proyecto añadido con exito");
			return true;
		} 
		else return false;
	}
	public int BuscarProyecto(String NombreProy) {
		int ret= SA.BuscarProyecto(NombreProy);
		return ret;
	}
	public void inidatos() {
		SA.inidatos();
	}
}
