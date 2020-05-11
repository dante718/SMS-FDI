package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.Inventario;

public class TablaInventario extends AbstractTableModel {

	private List<Inventario> listaInventario;
	
	private final String[] columnNames = {"#", "ID","Producto", "Cantidad", "Descripcion"};
	
	public TablaInventario(ControladorDeFabrica ctrl) {
		
		listaInventario = new ArrayList<Inventario>();
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaInventario.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return columnNames[c];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
