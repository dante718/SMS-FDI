package GestionDeProyectos;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

public class GDP_SAPersonaImp implements GDP_SAPersona{
  
    private GDP_DAOPersona daopersona;
    
    public GDP_SAPersonaImp() {
    	daopersona= new GDP_DAOPersonaImp();
    }
	@Override
	public TableModel leerdatosini(String tipo)  {

		TableModel TA= new GDP_TableModel();
		
	    TA = daopersona.leerdatosini(tipo);
	
		
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
	public void CrearProyecto(GDP_TProyecto proyecto,List<GDP_TPersona> participantes) {
		daopersona.CrearProyecto(proyecto,participantes);
	}
	@Override
	public void inidatos() {
		daopersona.inidatos();		
	}

}
