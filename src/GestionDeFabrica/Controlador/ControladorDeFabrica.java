package GestionDeFabrica.Controlador;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import GestionDeFabrica.Modelo.Fabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;
import GestionDeFabrica.Modelo.Pedidos;

public class ControladorDeFabrica implements FabricaObservadora {

	private Fabrica fabrica;
	
	public ControladorDeFabrica() {
		
	}

	public ControladorDeFabrica(Fabrica fac) {
		// TODO Auto-generated constructor stub
	}
	
	public ControladorDeFabrica()
	
	public void loadPedidosLaboratorio(InputStream in) {
		
		if (in != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(in));
			
			JSONArray ja = jo.getJSONArray("pedidosLaboratorio");
			
			for (int i = 0; i < ja.length(); i++) {
				
				//anade pedido
				//this.fabrica
			}
		}
	}
	
	public void reset() {
		
		this.fabrica.reset();
	}
	public void addObserver(FabricaObservadora o) {
		
		
	}

	@Override
	public void agregaPedidoLaboratorio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificaPedidoLaboratorio(Pedidos ped) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechazaPedidoLaboratorio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregaPedidoAlmacen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificaPedidoAlmacen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelaPedidoAlmacen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregaInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificaInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminaInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregaProyecto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificaProyecto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminaProyecto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error() {
		// TODO Auto-generated method stub
		
	}
}
