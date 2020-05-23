package GestionDeFabrica.PresentacionVista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.FabricaObservadora;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class TablaPedidosAlmacen extends AbstractTableModel implements FabricaObservadora{

	private List<PedidosTransfer> listaPedidosAlmacen;
	
	private final String[] columnNames = {"ID", "Usuario", "Producto", "Cantidad", "Estado"};
	
	public TablaPedidosAlmacen(ControladorDeFabrica ctrl) {
		
		ctrl.addObserver(this);
		listaPedidosAlmacen = new ArrayList<PedidosTransfer>();
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
		
		switch (columnIndex) {
		
			case 0 : return listaPedidosAlmacen.get(rowIndex).getIdPedido();
			
			case 1 : 
				
				if (listaPedidosAlmacen.get(rowIndex).getUsuario() != null) {
					
					return listaPedidosAlmacen.get(rowIndex).getUsuario();
				}
				else {
					
					return "Anonimo";
				}
				
			case 2 : return listaPedidosAlmacen.get(rowIndex).getProducto();
			
			case 3 : return listaPedidosAlmacen.get(rowIndex).getCantidad();
			
			case 4 : return listaPedidosAlmacen.get(rowIndex).getEstadoPedido();
			
			default : return false;
		
		}
	}

	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosAlmacen = mapa.getPedidosAlmacen();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosAlmacen = mapa.getPedidosAlmacen();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosAlmacen = mapa.getPedidosAlmacen();
		this.fireTableDataChanged();
	}

	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosAlmacen = mapa.getPedidosAlmacen();
		this.fireTableDataChanged();
	}

	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosAlmacen = mapa.getPedidosAlmacen();
		this.fireTableDataChanged();
	}
	
	
}
