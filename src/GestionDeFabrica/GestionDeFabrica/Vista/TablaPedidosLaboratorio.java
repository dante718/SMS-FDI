package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.PedidosLaboratorio;

public class TablaPedidosLaboratorio extends AbstractTableModel {

	private List<PedidosLaboratorio> listaPedidosLab;
	
	private final String[] columnNames = {"#", "ID", "Producto", "Cantidad"};
	
	public TablaPedidosLaboratorio(ControladorDeFabrica _ctrl) {
		
		listaPedidosLab = new ArrayList<PedidosLaboratorio>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPedidosLab.size();
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
