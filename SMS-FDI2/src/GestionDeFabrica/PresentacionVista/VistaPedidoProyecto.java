package GestionDeFabrica.PresentacionVista;

import java.util.List;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoProyecto extends VistaPedidosAbstracto {

	public VistaPedidoProyecto(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Gestoria de Proyecto";
		this.textoBotonAceptar = "Aceptar Pedido Fabricacion";
		this.textoBotonEliminar = "Rechazar Pedido";
		
		tabla = new TablaPedidoProyectos(this.controlador);
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
		
		new VistaCrearNuevoPedido(this.controlador, "pedido_proyecto", "Pedido Proyecto");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub

		new VistaEliminaPedido(this.controlador, "pedido_proyecto", "Pedido Proyecto", controlador.getListaPedidosProyecto());
	}
	
	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub

		new VistaModificaPedido(controlador, "Pedido Proyecto",  "pedido_proyecto", controlador.getListaPedidosProyecto());
	}

}
