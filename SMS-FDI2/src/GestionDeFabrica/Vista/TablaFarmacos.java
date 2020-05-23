package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.Farmaco;

public class TablaFarmacos extends AbstractTableModel {

	private List<Farmaco> listaFarmacos;
	
	private final String[] columnNames = {"#", "ID", "Nombre Comercial", "Compuesto Quimico", 
			"Cantidad a Producir"};
	
	public TablaFarmacos(ControladorDeFabrica _ctrl) {
		
		listaFarmacos = new ArrayList<Farmaco>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaFarmacos.size();
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
