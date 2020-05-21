package GestionDeFabrica.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import GestionDeFabrica.TransfersObjects.PedidosAbstractoTransfer;
import GestionDeFabrica.TransfersObjects.TransferPedidoImp;

public class PedidoProyectoDAO extends PedidosAbstractoDAO{

	public PedidoProyectoDAO(){
		
		this._file = "src/GestionDeFabrica/Almacen/json_proyecto.json";
		this.type = "pedido_proyecto";
	}
	
	@Override
	public PedidosAbstractoTransfer buscaPedido(String id) throws FileNotFoundException {
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
					
					String type = ja.getJSONObject(i).getString("type");
					String idPedido = ja.getJSONObject(i).getString("id");
					String usuario = ja.getJSONObject(i).getString("usuario");
					String nombre = ja.getJSONObject(i).getString("nombre");
					String producto = ja.getJSONObject(i).getString("producto");
					int cantidad = ja.getJSONObject(i).getInt("cantidad");
					String estado = ja.getJSONObject(i).getString("estado");
					
					TransferPedidoImp pedidoBuscado = new TransferPedidoImp();
					
					pedidoBuscado.setType(type);
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
