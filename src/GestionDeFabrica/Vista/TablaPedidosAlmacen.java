package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.PedidosAlmacen;

public class TablaPedidosAlmacen extends AbstractTableModel {

	private List<PedidosAlmacen> listaPedidosAlmacen;
	
	private final String[] columnNames = {"#", "ID", "Producto", "Cantidad"};
	
	public TablaPedidosAlmacen(ControladorDeFabrica ctrl) {
		
		listaPedidosAlmacen = new ArrayList<PedidosAlmacen>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPedidosAlmacen.size();
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
