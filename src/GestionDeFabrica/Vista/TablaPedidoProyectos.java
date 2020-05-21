package GestionDeFabrica.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class TablaPedidoProyectos extends AbstractTableModel implements FabricaObservadora{

	private List<PedidosTransfer> listaPedidoProyectos;
	
	private final String[] columnNames = {"ID", "Usuario", "Nombre Comercial", "Producto", "Compuesto Quimico", 
			"Cantidad a Producir", "Estado"};
	
	public TablaPedidoProyectos(ControladorDeFabrica ctrl) {
		
		ctrl.addObserver(this);
		listaPedidoProyectos = new ArrayList<PedidosTransfer>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPedidoProyectos.size();
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
		
		System.out.println(listaPedidoProyectos.get(rowIndex).getIdPedido());
		
		switch (columnIndex) {
		
			case 0 : return listaPedidoProyectos.get(rowIndex).getIdPedido();
			
			case 1 : return listaPedidoProyectos.get(rowIndex).getUsuario();
			
			case 2 : return listaPedidoProyectos.get(rowIndex).getNombre();
			
			case 3 : return listaPedidoProyectos.get(rowIndex).getProducto();
			
			case 4 : return listaPedidoProyectos.get(rowIndex).getCompuesto();
			
			case 5 : return listaPedidoProyectos.get(rowIndex).getCantidad();
			
			case 6 : return listaPedidoProyectos.get(rowIndex).getEstadoPedido();
			
			default : return false;
		}
	}

	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidoProyectos = mapa.getPedidosProyecto();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
		
		this.listaPedidoProyectos = mapa.getPedidosProyecto();
		this.fireTableDataChanged();
	}

	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub
	
		this.listaPedidoProyectos = mapa.getPedidosProyecto();
		this.fireTableDataChanged();
	}

	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidoProyectos = mapa.getPedidosProyecto();
		this.fireTableDataChanged();
	}

	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub
		
		this.listaPedidoProyectos = mapa.getPedidosProyecto();
		this.fireTableDataChanged();
	}

}
