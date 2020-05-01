package GestionProyectos.GDP.Modelo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public boolean BuscarProyecto(String nombreProy) {		
		return daoproyecto.BuscarProyecto(nombreProy);
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
	public boolean cambiarproyecto(String DNI, String NombreProy) {
		return daoproyecto.cambiarproyecto(DNI, NombreProy);
	}
	public void añadiraproyecto(String DNI, String NombreProy) {
		daoproyecto.añadirpersona(DNI, NombreProy);
		daopersona.AddProyecto(daoproyecto.getProyecto(NombreProy));
	}
	@Override
	public boolean compararfechas(String fechaAntigua) {
		Date NuevaDate = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");		
		try {
			Date AntiguaDate= sdf.parse(fechaAntigua);
			if(NuevaDate.getYear()==AntiguaDate.getYear()) {
				if(NuevaDate.getMonth()==AntiguaDate.getMonth()) {
					if(NuevaDate.getDay()-AntiguaDate.getDay()>=15) {
						return true;
					}
					else {
						return false;
					}
				}
				else if(NuevaDate.getMonth()>AntiguaDate.getMonth()) {
					return true;
				}
		  }
			else if(NuevaDate.getYear()>AntiguaDate.getYear()) {
				return true;
			}
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		return false;	
	}
	@Override
	public void GenerarNuevaVersion(String NombreProy) {
		daoproyecto.GenerarNuevaVersion(NombreProy);
		
	}
}
