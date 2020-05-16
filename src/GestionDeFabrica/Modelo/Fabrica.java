package GestionDeFabrica.Modelo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Fabrica implements Observable<FabricaObservadora> {

	protected MapaFabrica mapaFabrica;
	protected List<Event> listaEventos;
	
	protected Pedidos pedidos;
	protected List<Pedidos> listaPedidos;
	protected int time;
	
	protected List<FabricaObservadora> listaObservadores;
	
	public Fabrica() {
		
		this.mapaFabrica = new MapaFabrica();
		this.listaEventos = new ArrayList<Event>();
		
		//Capaz hay que eliminar todo esto
		//this.pedidos = new Pedidos();
		this.listaPedidos = new ArrayList<Pedidos>();
		
		this.listaObservadores = new ArrayList<FabricaObservadora>();
	}
	
	public void addEvent(Event e) {
		
		this.listaEventos.add(e);
		
		//TODO Hacer metodo notify
	}
	
	//Advance

	public void reset() {
		// TODO Auto-generated method stub
		
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
	}

	@Override
	public void removeObserver(FabricaObservadora o) {
		// TODO Auto-generated method stub
		
		this.listaObservadores.remove(o);
	}
	
	//TODO Falta hacer los metodos notify
	
}
