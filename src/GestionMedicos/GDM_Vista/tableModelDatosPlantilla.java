package GestionMedicos.GDM_Vista;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import GestionMedicos.FactoriaServAplicacion.TransDatosClinicos;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class tableModelDatosPlantilla extends AbstractTableModel{
	ArrayList<TransDatosClinicos>DatosClinicos;
	private ArrayList <String> Columnas;
	private Class[] TipoColumnas;

	
	
	ControladorMed controlador;
	public tableModelDatosPlantilla(ControladorMed control) {
		super();
		this.controlador=control;
		DatosClinicos=controlador.getListaPersonas();//new ArrayList<>();
	
		this.Columnas=controlador.getParametrosPlantilla();
		this.TipoColumnas= new Class[] {String.class,Integer.class,String.class,String.class,Integer.class
						};	
		
	}
	
	@Override
	public String getColumnName(int indice) {
		
		return Columnas.get(indice);
	}
	
	@Override 
	public Class <?>getColumnClass(int columnIndice){
		return this.TipoColumnas[columnIndice];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;		
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Columnas.size();
				}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.DatosClinicos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		switch(columna) {
		case 0: 
			return DatosClinicos.get(fila).getId();
		case 1:
			return DatosClinicos.get(fila).getEdad();
		case 2:
			return DatosClinicos.get(fila).getSexo();
		case 3:
			return DatosClinicos.get(fila).getFecha();
		case 4:
			return DatosClinicos.get(fila).GetCantidad();
		
			
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object Valor,int fila, int columna) {
		switch(columna) {
		case 0: 
			 DatosClinicos.get(fila).setId(Valor.toString());
		case 1:
		 DatosClinicos.get(fila).setEdad((int)Valor);
		case 2:
			 DatosClinicos.get(fila).setSexo(Valor.toString());
		case 3:
			 DatosClinicos.get(fila).setFecha(Valor.toString());
		case 4:
			 DatosClinicos.get(fila).setCantidad((int)Valor);
	
		default:
			;
		}
		this.fireTableCellUpdated(fila, columna);
		this.fireTableRowsUpdated(fila,columna);
		
	}
	 
	
	

}
