package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class SAImp implements SA{
  
    private DAOPersona daopersona;
    private DAOProyecto daoproyecto;
    public SAImp() {
    	daopersona= new DAOPersonaImp();
    	daoproyecto= new DAOProyectoImp();
    }
	@Override
	public ModeloTablaPersona creartablaPersonas(String tipo)  {

		ModeloTablaPersona TA= null;
		
	    TA = daopersona.creartablaPersonas(tipo);
	
		
		if(TA!=null) {
			return TA;
		}
		else return null;
	}

	@Override
	public int BuscarProyecto(String nombreProy) {
		int ret= daoproyecto.BuscarProyecto(nombreProy);	
		return ret;
	}

	@Override
	public void AddProyecto(TProyecto proyecto) {
		daopersona.AddProyecto(proyecto);
		daoproyecto.AddProyecto(proyecto);
	}
	@Override
	public void leerdatos() {
		daopersona.leerPersonas();	
		daoproyecto.leerProyectos();
	}
	@Override
	public boolean liberar(String DNI) {
		if(daoproyecto.LiberarPersonadeProyecto(DNI)) {
			daopersona.LiberarPersonadeProyecto(DNI);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public ModeloTablaProyectos creartablaProyectos() {
		ModeloTablaProyectos Tp= daoproyecto.creartablaProyectos();
		return Tp;
	}

}
