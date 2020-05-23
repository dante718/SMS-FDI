package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.Modelo.Pedidos;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class TablaPedidosLaboratorio extends AbstractTableModel implements FabricaObservadora {

	private List<PedidosTransfer> listaPedidosLab;
	
	private final String[] columnNames = {"ID", "Usuario", "Producto", "Cantidad"};
	
	public TablaPedidosLaboratorio(ControladorDeFabrica ctrl) {
		
		ctrl.addObserver(this);
		listaPedidosLab = new ArrayList<PedidosTransfer>();
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
		
		switch (columnIndex) {
		
		case 0 : return listaPedidosLab.get(rowIndex).getIdPedido();
		
		case 1 : return listaPedidosLab.get(rowIndex).getUsuario();
		
		case 2 : return listaPedidosLab.get(rowIndex).getProducto();
		
		case 3 : return listaPedidosLab.get(rowIndex).getCantidad();
		
		default : return false;
		}
	}

	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosLab = mapa.getPedidosLaboratorio();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosLab = mapa.getPedidosLaboratorio();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidosLab = mapa.getPedidosLaboratorio();
		this.fireTableDataChanged();
	}

	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosLab = mapa.getPedidosLaboratorio();
		this.fireTableDataChanged();
	}

	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidosLab = mapa.getPedidosLaboratorio();
		this.fireTableDataChanged();
	}


}
