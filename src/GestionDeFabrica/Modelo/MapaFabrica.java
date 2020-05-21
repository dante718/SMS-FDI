package GestionDeFabrica.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class MapaFabrica {

	protected Map<String, PedidosTransfer> mapaPedidosLab;
	protected Map<String, PedidosTransfer> mapaPedidosAl;
	protected Map<String, PedidosTransfer> mapaPedidoProyecto;
	protected Map<String, PedidosTransfer> mapaPedidoInventario;
	protected Map<String, PedidosTransfer> mapaPedidoEnvio;
	
	MapaFabrica(){
		
		this.mapaPedidosLab = new HashMap<String, PedidosTransfer>();
		this.mapaPedidosAl = new HashMap<String, PedidosTransfer>();
		this.mapaPedidoProyecto = new HashMap<String, PedidosTransfer>();
		this.mapaPedidoInventario = new HashMap<String, PedidosTransfer>();
		this.mapaPedidoEnvio = new HashMap<String, PedidosTransfer>();
	}
	
	void addPedidoLaboratorio (PedidosTransfer pLab) {
		
		if ( this.mapaPedidosLab.containsKey(pLab.getIdPedido())) {
			
			//throw new IllegalArgumentException("MapaFabrica: ya existe pedido laboratorio");
		}
		else {
			this.mapaPedidosLab.put(pLab.getIdPedido(), pLab);
		}
		
	}
	
	void eliminaPedidoLaboratorio (PedidosTransfer pLab) {
		

		if (this.mapaPedidosLab.containsKey(pLab.getIdPedido())) {
			
			this.mapaPedidosLab.remove(pLab.getIdPedido());
		}
		else {
			
			throw new IllegalArgumentException("MapaFabrica: no existe pedido" + pLab.getIdPedido());
		}
	}
	
	void addPedidoAlmacen (PedidosTransfer pAl) {
		
		System.out.println("hello");
		if ( this.mapaPedidosAl.containsKey(pAl.getIdPedido())) {
			
			//throw new IllegalArgumentException("MapaFabrica: ya existe el pedido de almacen");
		}
		else {
			
			System.out.println("hello2");
			this.mapaPedidosAl.put(pAl.getIdPedido(), pAl);
		}
	}
	
	void eliminaPedidoAlmacen (PedidosTransfer pAl) {
		
		if ( this.mapaPedidosAl.containsKey(pAl.getIdPedido())) {
			
			this.mapaPedidosAl.remove(pAl.getIdPedido());
		}
		else {
			
			throw new IllegalArgumentException("MapaFabrica: no existe pedido" + pAl.getIdPedido());
		}
	}
	
	void addPedidoProyecto (PedidosTransfer far) {
		
		if (this.mapaPedidoProyecto.containsKey(far.getIdPedido())) {
			
			//throw new IllegalArgumentException("MapaFabrica: ya existe el PedidoProyecto");
			System.out.println("MapaFabrica: ya existe el PedidoProyecto");
		}
		else {
			
			this.mapaPedidoProyecto.put(far.getIdPedido(), far);
		}
	}
	
	void eliminaPedidoProyecto (PedidosTransfer far) {
		
		if (this.mapaPedidoProyecto.containsKey(far.getIdPedido())) {
			
			this.mapaPedidoProyecto.remove(far.getIdPedido());
		}
		else {
			
			throw new IllegalArgumentException("Mapa fabrica: no existe pedido: " + far.getIdPedido());
		}
	}
	
	void addPedidoInventario(PedidosTransfer inv) {
		
		if (this.mapaPedidoInventario.containsKey(inv.getIdPedido())) {
			
			//throw new IllegalArgumentException("MapaFabrica: ya existe en el inventario");
		}
		else {
			
			this.mapaPedidoInventario.put(inv.getIdPedido(), inv);
		}
	}
	
	void eliminaPedidoInventario (PedidosTransfer inv) {
		
		if (this.mapaPedidoInventario.containsKey(inv.getIdPedido())) {
			
			this.mapaPedidoInventario.remove(inv.getIdPedido());
		}
		else {
			
			throw new IllegalArgumentException("Mapa fabrica: no existe pedido: " + inv.getIdPedido());
		}
	}
	
	void addPedidoEnvio (PedidosTransfer env) {
		
		if (this.mapaPedidoEnvio.containsKey(env.getIdPedido())) {
			
			//throw new IllegalArgumentException("MapaFabrica: ya existe el envio");
		}
		else {
			
			this.mapaPedidoEnvio.put(env.getIdPedido(), env);
		}
	}
	
	void eliminaPedidoEnvio (PedidosTransfer env) {
		
		if (this.mapaPedidoEnvio.containsKey(env.getIdPedido())) {
			
			this.mapaPedidoEnvio.remove(env.getIdPedido());
		}
		else {
			
			throw new IllegalArgumentException("MapaFabrica: no existe el envio");
		}
	}
	
	boolean contienePedido(String id) {
		
		if (this.mapaPedidoEnvio.containsKey(id) ||
				this.mapaPedidoInventario.containsKey(id) ||
				this.mapaPedidoProyecto.containsKey(id) ||
				this.mapaPedidoProyecto.containsKey(id) ||
				this.mapaPedidosAl.containsKey(id) ||
				this.mapaPedidosLab.containsKey(id)) {
			
			return true;
		}
		
		return false;
	}
	
	public List<PedidosTransfer> getPedidosProyecto(){
		
		List<PedidosTransfer> lista = new ArrayList<PedidosTransfer>(this.mapaPedidoProyecto.values());
		return lista;
	}
	
	public List<PedidosTransfer> getPedidosLaboratorio(){
		
		List<PedidosTransfer> lista = new ArrayList<PedidosTransfer>(this.mapaPedidosLab.values());
		
		return lista;
	}
	
	public List<PedidosTransfer> getPedidosAlmacen(){
		
		List<PedidosTransfer> lista = new ArrayList<PedidosTransfer>(this.mapaPedidosAl.values());
		
		return lista;
	}
	
	public List<PedidosTransfer> getPedidosInventario(){
		
		List<PedidosTransfer> lista = new ArrayList<PedidosTransfer>(this.mapaPedidoInventario.values());
		
		return lista;
	}
	
	public List<PedidosTransfer> getPedidosEnvio(){
		
		List<PedidosTransfer> lista = new ArrayList<PedidosTransfer>(this.mapaPedidoEnvio.values());
		
		return lista;
	}
	
	public JSONObject report() {
		
		return null;
	}
	
	void reset() {
		
		this.mapaPedidoInventario.clear();
		this.mapaPedidoProyecto.clear();
		this.mapaPedidosAl.clear();
		this.mapaPedidosLab.clear();
	}
}
