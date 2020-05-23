package GestionMedicos.CapaPresentacion;


import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;


import GestionMedicos.CapaDeNegocio.TransDatosClinicos;

public class tableModelDatosPlantilla extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<TransDatosClinicos>DatosClinicos;
	private ArrayList <String> Columnas;
	private Class[] TipoColumnas;

	
	
	ControladorMed controlador;
	public tableModelDatosPlantilla(ControladorMed control) {
		super();
		this.controlador=control;
		DatosClinicos=controlador.getListaPersonas();
	
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
			return DatosClinicos.get(fila).getSexo();
			
		case 2:
			return DatosClinicos.get(fila).getEdad();
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
	public void actualizar() {
		//realizar una recarga desde la base de datos
		this.DatosClinicos=this.controlador.recargarDatos();
	
	
		
	}
	 public void agregarFila() {
		 
		 
		
	 }
	
	

}
