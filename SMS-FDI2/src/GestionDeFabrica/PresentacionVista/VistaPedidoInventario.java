package GestionDeFabrica.PresentacionVista;

import java.util.List;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoInventario extends VistaPedidosAbstracto {

	public VistaPedidoInventario(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Gestoria De Inventario";
		this.textoBotonAceptar = "Agregar Producto";
		this.textoBotonEliminar = "Eliminar Producto";
		
		tabla = new TablaPedidoInventario(this.controlador);
		this.initGUI();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enPedidoAdded(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enPedidoEliminado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enPedidoModificado(MapaFabrica mapa, List<PedidosTransfer> pedidos, PedidosTransfer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enObservadoraRegistrada(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enReinicio(MapaFabrica mapa, List<PedidosTransfer> pedidos) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void accionAceptar() {
		// TODO Auto-generated method stub

		new VistaCrearNuevoPedido(this.controlador, "pedido_inventario", "Producto Inventario");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub

		new VistaEliminaPedido(this.controlador, "pedido_inventario", "Producto Inventario", controlador.getListaPedidosInventario());
	}
	
	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub

		new VistaModificaPedido(controlador, "Producto Inventario",  "pedido_inventario", controlador.getListaPedidosInventario());
	}

}
