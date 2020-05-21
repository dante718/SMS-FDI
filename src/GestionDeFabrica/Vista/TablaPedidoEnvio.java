package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class TablaPedidoEnvio extends AbstractTableModel implements FabricaObservadora {

	private List<PedidosTransfer> listaPedidosEnvio;
	
	private final String[] columnNames = {"ID", "Usuario", "Nombre", "Producto", "Compuesto", "Cantidad", "Estado"};
	
	public TablaPedidoEnvio(ControladorDeFabrica ctrl) {
		
		ctrl.addObserver(this);
		listaPedidosEnvio = new ArrayList<PedidosTransfer>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listaPedidosEnvio.size();
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
		
		case 0 : return listaPedidosEnvio.get(rowIndex).getIdPedido();
		
		case 1 : 
			
			if (listaPedidosEnvio.get(rowIndex).getUsuario() != null) {
				
				return listaPedidosEnvio.get(rowIndex).getUsuario();
			}
			else {
				
				return "Anonimo";
			}
		
		case 2 : return listaPedidosEnvio.get(rowIndex).getNombre();
		
		case 3 : return listaPedidosEnvio.get(rowIndex).getProducto();
		
		case 4 : return listaPedidosEnvio.get(rowIndex).getCantidad();
		
		case 5 : return listaPedidosEnvio.get(rowIndex).getEstadoPedido();
		
		default : return false;
		
		}
	}

	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosEnvio = mapa.getPedidosEnvio();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosEnvio = mapa.getPedidosEnvio();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosEnvio = mapa.getPedidosEnvio();
		this.fireTableDataChanged();
	}

	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosEnvio = mapa.getPedidosEnvio();
		this.fireTableDataChanged();
	}

	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosEnvio = mapa.getPedidosEnvio();
		this.fireTableDataChanged();
	}

}
