package GestionDeFabrica.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class MapaFabrica {

	protected List<PedidosLaboratorio> listaPedidosLab;
	protected Map<String, PedidosLaboratorio> mapaPedidosLab;
	protected List<PedidosAlmacen> listaPedidosAl;
	protected Map<String, PedidosAlmacen> mapaPedidosAl;
	protected List<Farmaco> listaFarmaco;
	protected Map<String, Farmaco> mapaFarmaco;
	protected List<Inventario> listaInventario;
	protected Map<String, Inventario> mapaInventario;
	
	MapaFabrica(){
		
		this.listaPedidosLab = new ArrayList<PedidosLaboratorio>();
		this.mapaPedidosLab = new HashMap<String, PedidosLaboratorio>();
		this.listaPedidosAl = new ArrayList<PedidosAlmacen>();
		this.mapaPedidosAl = new HashMap<String, PedidosAlmacen>();
		this.listaFarmaco = new ArrayList<Farmaco>();
		this.mapaFarmaco = new HashMap<String, Farmaco>();
		this.listaInventario = new ArrayList<Inventario>();
		this.mapaInventario = new HashMap<String, Inventario>();
	}
	
	void addPedidoLaboratorio (PedidosLaboratorio pLab) {
		//TODO agregar cantidad
		if ( this.mapaPedidosLab.containsKey(pLab.getId())) {
			
			throw new IllegalArgumentException("MapaFabrica: ya existe pedido laboratorio");
		}
		else {
			this.listaPedidosLab.add(pLab);
			this.mapaPedidosLab.put(pLab.getId(), pLab);
		}
	}
	
	void addPedidoAlmacen (PedidosAlmacen pAl) {
		//TODO agregar cantidad
		if ( this.mapaPedidosAl.containsKey(pAl.getId())) {
			
			throw new IllegalArgumentException("MapaFabrica: ya existe el pedido de almacen");
		}
		else {
			this.listaPedidosAl.add(pAl);
			this.mapaPedidosAl.put(pAl.getId(), pAl);
		}
	}
	
	void addFarmaco (Farmaco far) {
		//TODO agregar cantidad
		if (this.mapaFarmaco.containsKey(far.getId())) {
			
			throw new IllegalArgumentException("MapaFabrica: ya existe el farmaco");
		}
		else {
			
			this.listaFarmaco.add(far);
			this.mapaFarmaco.put(far.getId(), far);
		}
	}
	
	void addInventario(Inventario inv) {
		
		if (this.mapaInventario.containsKey(inv.getId())) {
			
			//TODO agregar cantidad
		}
		else {
			this.listaInventario.add(inv);
			this.mapaInventario.put(inv.getId(), inv);
		}
	}
	
	public JSONObject report() {
		
		return null;
	}
	
}
