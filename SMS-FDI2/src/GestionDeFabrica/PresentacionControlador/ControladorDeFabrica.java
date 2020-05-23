package GestionDeFabrica.PresentacionControlador;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import GestionDeFabrica.PresentacionModelo.Fabrica;
import GestionDeFabrica.PresentacionModelo.FabricaObservadora;
import GestionDeFabrica.PresentacionModelo.MapaFabrica;
import GestionDeFabrica.PresentacionVista.VistaPrincipal;
import GestionDeFabrica.ServicioDeAplicacion.FactoriaSAPedidos;
import GestionDeFabrica.ServicioDeAplicacion.FactoriaSAUsuario;
import GestionDeFabrica.ServicioDeAplicacion.SAPedido;
import GestionDeFabrica.ServicioDeAplicacion.SAPedidos;
import GestionDeFabrica.ServicioDeAplicacion.SAUsuario;
import GestionDeFabrica.ServicioDeAplicacion.SAUsuarios;
import GestionDeFabrica.TransfersObjects.FactoriaTransferPedidos;
import GestionDeFabrica.TransfersObjects.FactoriaTransferUsuario;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.TransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class ControladorDeFabrica implements FabricaObservadora {

	private Fabrica fabrica;
	private FactoriaTransferPedidos factoriaTA;
	private PedidosTransfer pedidosTA;
	private FactoriaTransferUsuario factoriaTAu;
	private UsuarioTransfer usuarioTA;
	private FactoriaSAPedidos factoriaSAp;
	private SAPedidos servicioPedidos;
	private FactoriaSAUsuario factoriaSAu;
	private SAUsuarios servicioUsuario;
	
	private VistaPrincipal vistaPrincipal;

	public ControladorDeFabrica(Fabrica fac) {
		// TODO Auto-generated constructor stub
		
		this.fabrica = fac;
		
		this.factoriaSAp = this.factoriaSAp.dameInstancia();
		this.servicioPedidos = this.factoriaSAp.generaSAPedidos();
		
		this.factoriaSAu = this.factoriaSAu.dameInstancia();
		this.servicioUsuario = this.factoriaSAu.generaSAUsuario();
		//this.servicio = new SAPedido();
	}
	
	public void initGUI() {
		
		this.loadUsuarios();
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaPrincipal.initGUI();
	}
	
	public void loadPedidos(List<PedidosTransfer> in) {
		
		for (int i = 0; i < in.size(); i++) {
			
			this.fabrica.addPedido(in.get(i));
		}
	}
	
	public void addUsuario(UsuarioTransfer usuario) {
		
		this.fabrica.addUsuario(usuario);
		this.servicioUsuario.insertarUsuario(usuario);
	}
	
	public void eliminaUsuario(UsuarioTransfer usuario) {
		
		this.fabrica.eliminaUsuario(usuario);
		this.servicioUsuario.eliminaUsuario(usuario);
	}
	
	public void modificaUsuario(UsuarioTransfer usuario) {
		
		this.fabrica.modificaUsuario(usuario);
		this.servicioUsuario.modificaUsuario(usuario);
	}
	
	public boolean tieneUsuario(String string) {
		
		return this.fabrica.contieneUsuario(string);
	}
	//public boolean contraCorrecta(UsuarioTransfer usuario) {
		
	//	return this.fabrica.contraCorrecta(usuario);
	//}
	
	public void loadUsuarios() {
		
		List<UsuarioTransfer> listaUsuarios = new ArrayList<UsuarioTransfer>();
		
		listaUsuarios.addAll(this.servicioUsuario.solicitaUsuarios());
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			
			this.fabrica.addUsuario(listaUsuarios.get(i));
		}
	}
	
	public void solicitaPedidos() {
		
		List<PedidosTransfer> listaPedidos = new ArrayList<PedidosTransfer>();
		
		this.factoriaTA = FactoriaTransferPedidos.dameInstancia();
		this.pedidosTA = this.factoriaTA.generaObjetoPedidoTransfer();
		
		this.pedidosTA.setType("pedido_proyecto");
		listaPedidos.addAll(this.servicioPedidos.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_laboratorio");
		listaPedidos.addAll(this.servicioPedidos.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_almacen");
		listaPedidos.addAll(this.servicioPedidos.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_inventario");
		listaPedidos.addAll(this.servicioPedidos.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_envio");
		listaPedidos.addAll(this.servicioPedidos.solicitaPedidos(this.pedidosTA));
		
		this.loadPedidos(listaPedidos);
	}
	
	public void agregaPeidido(PedidosTransfer pedido) {
		
		this.fabrica.addPedido(pedido);
		this.servicioPedidos.insertaPedido(pedido);
	}
	
	public void modificaPedido(PedidosTransfer pedido) {
		
		this.fabrica.modificaPedido(pedido);
		this.servicioPedidos.modificaPedido(pedido);
	}
	
	public void eliminaPedido(PedidosTransfer pedido) {
		
		this.fabrica.eliminaPedido(pedido);
		this.servicioPedidos.eliminaPedido(pedido);
	}
	
	public boolean contienePedido(String id) {
		
		return this.fabrica.contienePedido(id);
	}
	
	public UsuarioTransfer getUsuario(String dni) {
		
		TransferUsuarioImp us = new TransferUsuarioImp();
		us.setDNI(dni);
		return this.servicioUsuario.buscaUsuario(us);
	}
	public List<UsuarioTransfer> getListaUsuarios(){
		
		return this.fabrica.getListaUsuarios();
	}
	public List<PedidosTransfer> getListaPedidosProyecto(){
		
		return this.fabrica.getListaPedidosProyecto();
	}
	public List<PedidosTransfer> getListaPedidosLaboratorio(){
		
		return this.fabrica.getListaPedidosLaboratorio();
	}
	public List<PedidosTransfer> getListaPedidosAlmacen(){
		
		return this.fabrica.getListaPedidosAlmacen();
	}
	public List<PedidosTransfer> getListaPedidosInventario(){
		
		return this.fabrica.getListaPedidosInventario();
	}
	public List<PedidosTransfer> getListaPedidosEnvio(){
		
		return this.fabrica.getListaPedidosEnvio();
	}
	
	public void reset() {
		
		this.fabrica.reset();
	}
	public void addObserver(FabricaObservadora o) {
		
		this.fabrica.addObserver(o);
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
	
	
}
