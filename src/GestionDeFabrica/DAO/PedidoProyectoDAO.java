package GestionDeFabrica.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import GestionDeFabrica.TransfersObjects.PedidoTransferProyecto;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public class PedidoProyectoDAO extends PedidosAbstractoDAO{

	public PedidoProyectoDAO(){
		
		this._file = "resourse/bd/proyecto.json";
	}
	
	@Override
	public PedidosTransfer buscaPedido(String id) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String id1 = ja.getJSONObject(i).getString("id");
				
				if (id1.equals(id) && encontrado != true ) {
					
					String idPedido = ja.getJSONObject(i).getString("id");
					String usuario = ja.getJSONObject(i).getString("usuario");
					String nombre = ja.getJSONObject(i).getString("nombre");
					String producto = ja.getJSONObject(i).getString("producto");
					int cantidad = ja.getJSONObject(i).getInt("cantidad");
					String estado = ja.getJSONObject(i).getString("estado");
					
					PedidoTransferProyecto pedidoBuscado = new PedidoTransferProyecto();
					
					pedidoBuscado.setIdPedido(idPedido);
					pedidoBuscado.setUsuario(usuario);
					pedidoBuscado.setNombre(nombre);
					pedidoBuscado.setProducto(producto);
					pedidoBuscado.setCantidad(cantidad);
					pedidoBuscado.setEstadoPedido(estado);
					
					encontrado = true;
					
					return pedidoBuscado;
				}
			}
		}
		return null;
	}
}
