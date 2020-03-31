
package GestionDeProyectos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class GDP_TableModel implements TableModel{
    private List<GDP_TPersona> personas;
    private String[] campos= {"DNI", "Nombre", "Apellido1", "Apellido2", "Profesion", "Estado", "Rol"};
    public GDP_TableModel() {
    	personas= new ArrayList<GDP_TPersona>();
    }   
    
	public void addPersonas(GDP_TPersona persona){	
	    personas.add(persona);		
	}

	@Override
	public int getRowCount() {	
		return personas.size();
	}

	@Override
	public int getColumnCount() {		
		return campos.length;
	}

	@Override
	public String getColumnName(int columnIndex) {		
		return campos[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String ret=null;
		switch(columnIndex) {
		case 0:
			ret=personas.get(rowIndex).getDNI();
			break;
		case 1:
			ret=personas.get(rowIndex).getNombre();
			break;
		case 2:
			ret=personas.get(rowIndex).getApellido1();
			break;
		case 3:
			ret=personas.get(rowIndex).getApellido2();
			break;
		case 4:
			ret=personas.get(rowIndex).getProfesion();
			break;
		case 5:
			ret=personas.get(rowIndex).getEstado();
			break;
		case 6:
			ret=personas.get(rowIndex).getRol();
			break;	
		}
		return ret;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	
	}

}
