package GestionProyectos.GDP.Integracion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionProyectos.GDP.Negocio.TPersona;

@SuppressWarnings("serial")
public class ModeloTablaPersona extends AbstractTableModel{
	 private List<TPersona> personas;
	 private String[] campos= {"DNI", "Nombre", "Apellido1", "Apellido2", "Profesion", "Estado", "Rol"};
	 public ModeloTablaPersona() {
		 personas= new ArrayList<TPersona>();
	 }
	 
	 public void addPersonas(TPersona persona){	
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
			ret=personas.get(rowIndex).leerDNI();
			break;
		case 1:
			ret=personas.get(rowIndex).leerNombre();
			break;
		case 2:
			ret=personas.get(rowIndex).leerApellido1();
			break;
		case 3:
			ret=personas.get(rowIndex).leerApellido2();
			break;
		case 4:
			ret=personas.get(rowIndex).leerProfesion();
			break;
		case 5:
			ret=personas.get(rowIndex).leerEstado();
			break;
		case 6:
			ret=personas.get(rowIndex).leerRol();
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
    public List<TPersona> getPersonas() {
    	return personas;
    }
    public void removeFila(int fila) {
    	personas.remove(fila);
    }
    public TPersona getPersona(int index) {
    	return personas.get(index);
    }
}
