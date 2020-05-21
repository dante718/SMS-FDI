package GestionDeFabrica.Controlador;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import GestionDeFabrica.Modelo.Fabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;
import GestionDeFabrica.Modelo.MapaFabrica;
import GestionDeFabrica.Modelo.Pedidos;
import GestionDeFabrica.ServicioDeAplicacion.FactoriaSAPedidos;
import GestionDeFabrica.ServicioDeAplicacion.SAPedido;
import GestionDeFabrica.ServicioDeAplicacion.SAPedidos;
import GestionDeFabrica.TransfersObjects.FactoriaTransferPedidos;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.Vista.VistaPrincipal;

public class ControladorDeFabrica implements FabricaObservadora {

	private Fabrica fabrica;
	private FactoriaTransferPedidos factoriaTA;
	private PedidosTransfer pedidosTA;
	private FactoriaSAPedidos factoriaSA;
	private SAPedidos servicio;
	
	private VistaPrincipal vistaPrincipal;

	public ControladorDeFabrica(Fabrica fac) {
		// TODO Auto-generated constructor stub
		
		this.fabrica = fac;
		this.factoriaSA = this.factoriaSA.dameInstancia();
		this.servicio = this.factoriaSA.generaSAPedidos();
		//this.servicio = new SAPedido();
	}
	
	public void initGUI() {
		
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaPrincipal.initGUI();
	}
	
	public void loadPedidos(List<PedidosTransfer> in) {
		
		for (int i = 0; i < in.size(); i++) {
			
			this.fabrica.addPedido(in.get(i));
		}
	}
	
	public void solicitaPedidos() {
		
		List<PedidosTransfer> listaPedidos = new ArrayList<PedidosTransfer>();
		
		this.factoriaTA = FactoriaTransferPedidos.dameInstancia();
		this.pedidosTA = this.factoriaTA.generaObjetoPedidoTransfer();
		
		this.pedidosTA.setType("pedido_proyecto");
		listaPedidos.addAll(this.servicio.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_laboratorio");
		listaPedidos.addAll(this.servicio.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_almacen");
		listaPedidos.addAll(this.servicio.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_inventario");
		listaPedidos.addAll(this.servicio.solicitaPedidos(this.pedidosTA));
		
		this.pedidosTA.setType("pedido_envio");
		listaPedidos.addAll(this.servicio.solicitaPedidos(this.pedidosTA));
		
		this.loadPedidos(listaPedidos);
	}
	
	public void agregaPeidido(PedidosTransfer pedido) {
		
		this.fabrica.addPedido(pedido);
		this.servicio.insertaPedido(pedido);
	}
	
	public void modificaPedido(PedidosTransfer pedido) {
		
		this.fabrica.modificaPedido(pedido);
		this.servicio.modificaPedido(pedido);
	}
	
	public void eliminaPedido(PedidosTransfer pedido) {
		
		this.fabrica.eliminaPedido(pedido);
		this.servicio.eliminaPedido(pedido);
	}
	
	public boolean contienePedido(String id) {
		
		return this.fabrica.contienePedido(id);
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
