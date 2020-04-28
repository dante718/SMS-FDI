package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class GDP_SAPersonaImp implements GDP_SAPersona{
  
    private GDP_DAOPersona daopersona;
    
    public GDP_SAPersonaImp() {
    	daopersona= new GDP_DAOPersonaImp();
    }
	@Override
	public GDP_ModeloTabla creartabla(String tipo)  {

		GDP_ModeloTabla TA= null;
		
	    TA = daopersona.creartabla(tipo);
	
		
		if(TA!=null) {
			return TA;
		}
		else return null;
	}

	@Override
	public int BuscarProyecto(String nombreProy) {
		int ret= daopersona.BuscarProyecto(nombreProy);	
		return ret;
	}

	@Override
	public void AddProyecto(GDP_TProyecto proyecto) {
		daopersona.AddProyecto(proyecto);
	}
	@Override
	public void leerdatos() {
		daopersona.leerdatos();		
	}
	@Override
	public void liberar(String DNI) {
		daopersona.liberar(DNI);
	}

}
