package GestionDeFabrica.PresentacionVista;

import java.util.List;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoLaboratorio extends VistaPedidosAbstracto {

	public VistaPedidoLaboratorio(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Gestoria Pedidos Laboratorio";
		this.textoBotonAceptar = "Aceptar Pedido";
		this.textoBotonEliminar = "Rechazar Pedido";
		
		tabla = new TablaPedidosLaboratorio(this.controlador);
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

		new VistaCrearNuevoPedido(this.controlador, "pedido_laboratorio", "Pedido Laboratorio");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub

		new VistaEliminaPedido(this.controlador, "pedido_laboratorio", "Pedido Laboratorio", controlador.getListaPedidosLaboratorio());
	}
	
	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub

		new VistaModificaPedido(controlador, "Pedido Laboratorio",  "pedido_laboratorio", controlador.getListaPedidosLaboratorio());
	}

}
