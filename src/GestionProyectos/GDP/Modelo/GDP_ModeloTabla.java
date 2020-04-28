package GestionProyectos.GDP.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GDP_ModeloTabla extends AbstractTableModel{
	 private List<GDP_TPersona> personas;
	 private String[] campos= {"DNI", "Nombre", "Apellido1", "Apellido2", "Profesion", "Estado", "Rol"};
	 public GDP_ModeloTabla() {
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object ret=null;
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
    public String getColumnName(int indice) {
    	return campos[indice];
    }
    public void actualizar() {
    	this.fireTableDataChanged();
    }
}
