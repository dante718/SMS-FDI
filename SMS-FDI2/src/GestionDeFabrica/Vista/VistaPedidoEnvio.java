package GestionDeFabrica.Vista;

import java.util.List;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoEnvio extends VistaPedidosAbstracto {

	public VistaPedidoEnvio(ControladorDeFabrica controlador) {
		super(controlador);
		this.titulo = "Gestoria De Envios";
		this.textoBotonAceptar = "Crear Nuevo Envio";
		this.textoBotonEliminar = "Cancelar Pedido";
		
		tabla = new TablaPedidoEnvio(this.controlador);
		
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

		new VistaCrearNuevoPedido(this.controlador, "pedido_envio", "Envio");
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub

		new VistaEliminaPedido(this.controlador, "pedido_envio", "Envio", controlador.getListaPedidosEnvio());
	}
	
	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub

		new VistaModificaPedido(controlador, "Envio",  "pedido_envio", controlador.getListaPedidosEnvio());
	}

}
