package GestionDeFabrica.PresentacionVista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.FabricaObservadora;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class TablaPedidosUsuarios extends AbstractTableModel implements FabricaObservadora{

	private List<UsuarioTransfer> listaUsuarios;
	
	private final String[] columnNames = {"DNI", "Nombre", "Apellido1", "Apellido2", "Disponibilidad",
										"Telefono", "Proyecto"};
	
	public TablaPedidosUsuarios(ControladorDeFabrica ctrl) {
		
		ctrl.addObserver(this);
		listaUsuarios = new ArrayList<UsuarioTransfer>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaUsuarios.size();
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
		
		switch (columnIndex) {
		
			case 0 : return listaUsuarios.get(rowIndex).getDNI();
			
			case 1 : return listaUsuarios.get(rowIndex).getNombre();
			
			case 2 : return listaUsuarios.get(rowIndex).getApellido1();
			
			case 3 : return listaUsuarios.get(rowIndex).getApellido2();
			
			case 4 : if (listaUsuarios.get(rowIndex).getDisponibilidad()) {
						return "Disponible";
					}
					else {
						return "No Disponible";
					}
			
			case 5 : return listaUsuarios.get(rowIndex).getTelefono();
			
			case 6 : return listaUsuarios.get(rowIndex).getProyecto();
			
			default : return "";
		}
	}
	
	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios = mapa.getUsuarios();
		this.fireTableDataChanged();
	}
	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios = mapa.getUsuarios();
		this.fireTableDataChanged();
	}
	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios = mapa.getUsuarios();
		this.fireTableDataChanged();
	}
	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios = mapa.getUsuarios();
		this.fireTableDataChanged();
	}
	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios = mapa.getUsuarios();
		this.fireTableDataChanged();
	}

}
