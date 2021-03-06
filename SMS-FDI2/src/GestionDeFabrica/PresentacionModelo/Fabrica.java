package GestionDeFabrica.PresentacionModelo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class Fabrica implements Observable<FabricaObservadora> {

	protected MapaFabrica mapaFabrica;
	
	protected List<PedidosTransfer> listaPedidos;
	protected int time;
	
	protected List<FabricaObservadora> listaObservadores;
	
	public Fabrica() {
		
		this.mapaFabrica = new MapaFabrica();
		this.listaPedidos = new ArrayList<PedidosTransfer>();
		
		this.listaObservadores = new ArrayList<FabricaObservadora>();
	}
	
	public void addUsuario(UsuarioTransfer usuario) {
		
		this.mapaFabrica.addUsuario(usuario);
		
		this.notifyOnPedidoAdded(null);
	}
	
	public void addPedido(PedidosTransfer pedido) {
		
		if ( pedido.equals(null)) {
			
		}
		if (pedido.getType().equals("pedido_proyecto")) {
			
			this.mapaFabrica.addPedidoProyecto(pedido);
		}
		else if (pedido.getType().equals("pedido_laboratorio")) {
			
			this.mapaFabrica.addPedidoLaboratorio(pedido);
		}
		else if (pedido.getType().equals("pedido_almacen")) {
			
			this.mapaFabrica.addPedidoAlmacen(pedido);
		}
		else if (pedido.getType().equals("pedido_inventario")) {
			
			this.mapaFabrica.addPedidoInventario(pedido);
		}
		else if (pedido.getType().equals("pedido_envio")) {
			
			this.mapaFabrica.addPedidoEnvio(pedido);
		}
		else {
			System.out.println("no deberia de entrar aqui");
		}
		
		this.listaPedidos.add(pedido);
		
		this.notifyOnPedidoAdded(pedido);
	}
	
	public void eliminaUsuario(UsuarioTransfer usuario) {
		
		this.mapaFabrica.eliminaUsuario(usuario);
		
		this.notifyOnPedidoEliminado(null);
	}
	
	public void eliminaPedido(PedidosTransfer pedido) {
		
		if (pedido.getType().equals("pedido_proyecto")) {
			
			this.mapaFabrica.eliminaPedidoProyecto(pedido);
		}
		else if (pedido.getType().equals("pedido_laboratorio")) {
			
			this.mapaFabrica.eliminaPedidoLaboratorio(pedido);
		}
		else if (pedido.getType().equals("pedido_almacen")) {
			
			this.mapaFabrica.eliminaPedidoAlmacen(pedido);
		}
		else if (pedido.getType().equals("pedido_inventario")) {
			
			this.mapaFabrica.eliminaPedidoInventario(pedido);
		}
		else if (pedido.getType().equals("pedido_envio")) {
			
			this.mapaFabrica.eliminaPedidoEnvio(pedido);
		}
		else {
			System.out.println("no deberia de entrar aqui");
		}
		
		this.notifyOnPedidoEliminado(pedido);
	}
	
	public void modificaUsuario(UsuarioTransfer usuario) {
		
		this.eliminaUsuario(usuario);
		this.addUsuario(usuario);
		
		this.notifyOnPedidoModificado(null);
	}
	
	public void modificaPedido(PedidosTransfer pedido) {
		
		this.eliminaPedido(pedido);
		this.addPedido(pedido);
		
		this.notifyOnPedidoModificado(pedido);
	}
	
	public boolean contieneUsuario(String string) {
		
		return this.mapaFabrica.contieneUsuario(string);
	}
	
	public List<UsuarioTransfer> getListaUsuarios(){
		
		return this.mapaFabrica.getUsuarios();
	}
	
	public boolean contienePedido(String id) {
		
		return this.mapaFabrica.contienePedido(id);
	}
	public List<PedidosTransfer> getListaPedidosProyecto(){
		
		return this.mapaFabrica.getPedidosProyecto();
	}
	public List<PedidosTransfer> getListaPedidosLaboratorio(){
		
		return this.mapaFabrica.getPedidosLaboratorio();
	}
	public List<PedidosTransfer> getListaPedidosAlmacen(){
		
		return this.mapaFabrica.getPedidosAlmacen();
	}
	public List<PedidosTransfer> getListaPedidosInventario(){
		
		return this.mapaFabrica.getPedidosInventario();
	}
	public List<PedidosTransfer> getListaPedidosEnvio(){
		
		return this.mapaFabrica.getPedidosEnvio();
	}
	
	//Advance

	public void reset() {
		// TODO Auto-generated method stub
		
		this.notifyOnReinicio();
	}
	
	public JSONObject report() {
		
		JSONObject jo = new JSONObject();
		
		jo.putOnce("time", this.time);
		
		jo.putOnce("state", this.mapaFabrica.report());
		
		return jo;
	}

	@Override
	public void addObserver(FabricaObservadora o) {
		// TODO Auto-generated method stub
		
		this.listaObservadores.add(o);
		
		this.notifyOnObservadoraAdded(o);
	}

	@Override
	public void removeObserver(FabricaObservadora o) {
		// TODO Auto-generated method stub
		
		this.listaObservadores.remove(o);
	}
	
	private void notifyOnPedidoAdded(PedidosTransfer e) {
		
		for ( FabricaObservadora observadora : this.listaObservadores) {
			
			observadora.enPedidoAdded(mapaFabrica, listaPedidos, e);
		}
	}
	
	private void notifyOnPedidoEliminado(PedidosTransfer e) {
		
		for ( FabricaObservadora observadora : this.listaObservadores) {
			
			observadora.enPedidoEliminado(mapaFabrica, listaPedidos, e);
		}
	}
	
	private void notifyOnPedidoModificado(PedidosTransfer e) {
		
		for ( FabricaObservadora observadora : this.listaObservadores) {
			
			observadora.enPedidoModificado(mapaFabrica, listaPedidos, e);
		}
	}
	
	private void notifyOnObservadoraAdded(FabricaObservadora o) {
		
		o.enObservadoraRegistrada(mapaFabrica, listaPedidos);
	}
	
	private void notifyOnReinicio() {
		
		for ( FabricaObservadora observadora : this.listaObservadores) {
			
			observadora.enReinicio(mapaFabrica, listaPedidos);
		}
	}
}
