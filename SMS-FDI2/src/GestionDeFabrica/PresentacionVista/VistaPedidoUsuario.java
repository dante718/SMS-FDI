package GestionDeFabrica.PresentacionVista;

import java.util.List;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class VistaPedidoUsuario extends VistaPedidosAbstracto {

	public VistaPedidoUsuario(ControladorDeFabrica controlador) {
		super(controlador);
		
		this.titulo = "Gestion Usuarios Fabrica";
		this.textoBotonAceptar = "Crear Nuevo Usuario";
		this.textoBotonEliminar = "Eliminar Usuario";
		// TODO Auto-generated constructor stub
		
		tabla = new TablaPedidosUsuarios(this.controlador);
		this.initGUI();
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

		new VistaCrearUsuario(this.controlador);
	}

	@Override
	protected void accionElimina() {
		// TODO Auto-generated method stub
		
		new VistaEliminarUsuario(controlador);
	}

	@Override
	protected void accionModifica() {
		// TODO Auto-generated method stub
		new VistaModificaUsuario(controlador);
	}

}
