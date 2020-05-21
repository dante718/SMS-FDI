package GestionDeFabrica.Vista;

import java.util.List;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoAlmacen extends VistaPedidosAbstracto {

	public VistaPedidoAlmacen(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Gestion Pedidos Almacen";
		this.textoBotonAceptar = "Crea Nuevo Pedido";
		this.textoBotonEliminar = "Cancela Un Pedido";
		
		tabla = new TablaPedidosAlmacen(this.controlador);
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

		new VistaCrearNuevoPedido(this.controlador, "pedido_almacen", "Pedido Almacen");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub
		
		new VistaEliminaPedido(this.controlador, "pedido_almacen", "Pedido Almacen", controlador.getListaPedidosAlmacen());
	}
	
	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub

		new VistaModificaPedido(controlador, "Pedido Almacen",  "pedido_almacen", controlador.getListaPedidosAlmacen());
	}

}
