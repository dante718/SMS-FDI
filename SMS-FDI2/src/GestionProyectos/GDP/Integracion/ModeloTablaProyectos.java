package GestionProyectos.GDP.Integracion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionProyectos.GDP.Negocio.TProyecto;

public class ModeloTablaProyectos extends AbstractTableModel{
    private List<TProyecto> proyectos;
    //FechaUV fecha de ultima version
    private String [] campos= {"Nombre", "Descripcion", "NParticipantes", "VersionActual", "FechaUV","En Fabricacion"};
    public ModeloTablaProyectos() {
    	proyectos= new ArrayList<TProyecto>();
    }
    public void actualizar() {
    	this.fireTableDataChanged();
    }
    public void addProyecto(TProyecto proyecto) {
    	proyectos.add(proyecto);
    }
	@Override
	public int getRowCount() {
		return proyectos.size();
	}

	@Override
	public int getColumnCount() {
		return campos.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object o=null;
		switch(columnIndex) {
		case 0:
			o=proyectos.get(rowIndex).leerNombre();
			break;
		case 1:
			o=proyectos.get(rowIndex).leerDescripcion();
			break;
		case 2:
			o=proyectos.get(rowIndex).leerNparticipantes();
			break;
		case 3:
			o=proyectos.get(rowIndex).leerVersion();
			break;
		case 4:
			o=proyectos.get(rowIndex).leerFecha();
			break;
		case 5:
			o=proyectos.get(rowIndex).leerFabricacion();
			break;
		}
		return o;
	}
     public String getColumnName(int index) {
    	 return campos[index];
     }
     public TProyecto getProyecto(int index) {  	 
    	 return proyectos.get(index);
     }
}
