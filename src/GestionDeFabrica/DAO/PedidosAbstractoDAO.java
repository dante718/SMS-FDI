package GestionDeFabrica.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import GestionDeFabrica.Modelo.EstadoPedido;
import GestionDeFabrica.TransfersObjects.PedidoTransferProyecto;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;

public abstract class PedidosAbstractoDAO implements PedidosDAO {

	protected String _file;
	//protected OutputStream out;
	protected String type;
	protected String id;
	protected String usuario;
	protected String nombre;
	protected String producto;
	protected int cantidad;
	protected EstadoPedido estado;
	
	
	/*PedidosAbstractoDAO(String type, String id, String usuario, String nombre, String producto, int cantidad){
		
		if (type == null || id == null) {
			
			throw new IllegalArgumentException("PedidosAbstractoDAO: type o id no definidos");
		}
		else if (usuario == null) {
			
			throw new IllegalArgumentException("PedidosAbstractoDAO: Usuario no definido");
		}
		else if (producto == null || cantidad == 0) {
			
			throw new IllegalArgumentException("PedidosAbstractoDAO: producto o cantidad no definidos");
		}
		else {
			this.type = type;
			this.id = id;
			this.usuario = usuario;
			this.nombre = nombre;
			this.producto = producto;
			this.cantidad = cantidad;
			this.estado = EstadoPedido.EN_PROCESO;
		}
	}*/
	
	@Override
	public boolean insertarPedido(PedidosTransfer nuevoPedido) throws FileNotFoundException {
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		OutputStream out = _outFile == null ? System.out : new FileOutputStream(new File(_outFile));
		PrintStream p = new PrintStream(out);
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String id = ja.getJSONObject(i).getString("id");
				
				if (id.equals(nuevoPedido.getIdPedido()) && encontrado != true) {
					
					encontrado = true;
					this.modificaPedido(nuevoPedido);
				}
				else if (id.equals(null) && encontrado != true) {
					
					ja.getJSONObject(i).put("id", nuevoPedido.getIdPedido());
					ja.getJSONObject(i).put("usuario", nuevoPedido.getUsuario());
					ja.getJSONObject(i).put("nombre", nuevoPedido.getNombre());
					ja.getJSONObject(i).put("producto", nuevoPedido.getProducto());
					ja.getJSONObject(i).put("cantidad", nuevoPedido.getCantidad());
					ja.getJSONObject(i).put("estado", nuevoPedido.getEstadoPedido().toString());
					
					encontrado = true;
				}
			}
			
			jo.put("array", ja);
			
			p.print(jo);
		}
		/*JSONObject jo = new JSONObject();
		
		jo.put("type", this.type);
		
		JSONArray ja = new JSONArray();
		
		JSONObject j1 = new JSONObject();
		
		j1.put("id", this.id);
		j1.put("usuario", this.usuario);
		j1.put("producto", this.producto);
		j1.put("cantidad", this.cantidad);
		j1.put("estado", this.estado.toString());
		
		ja.put(j1);
		
		jo.put("data", ja);
		
		PrintStream print = new PrintStream(this.out);
		
		print.println(jo);
		*/
		return encontrado;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eliminaPedido(PedidosTransfer pedido) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		OutputStream out = _outFile == null ? System.out : new FileOutputStream(new File(_outFile));
		PrintStream p = new PrintStream(out);
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String id = ja.getJSONObject(i).getString("id");
				
				if (id.equals(pedido.getIdPedido())) {
					
					ja.getJSONObject(i).put("id", "null");
					ja.getJSONObject(i).put("usuario", "null");
					ja.getJSONObject(i).put("nombre", "null");
					ja.getJSONObject(i).put("producto", "null");
					ja.getJSONObject(i).put("cantidad", 0);
					ja.getJSONObject(i).put("estado", "null");
					
					encontrado = true;
				}
			}
		}
		return encontrado;
	}

	@Override
	public boolean modificaPedido(PedidosTransfer pedido) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		boolean encontrado = false;
		
		String _inFile = this._file;
		String _outFile = this._file;
		InputStream isr = new FileInputStream(new File(_inFile));
		OutputStream out = _outFile == null ? System.out : new FileOutputStream(new File(_outFile));
		PrintStream p = new PrintStream(out);
		
		if (isr != null) {
			
			JSONObject jo = new JSONObject(new JSONTokener(isr));
			
			JSONArray ja = jo.getJSONArray("array");
			
			for (int i = 0; i < ja.length(); i++) {
				
				String id = ja.getJSONObject(i).getString("id");
				
				if (id.equals(pedido.getIdPedido())) {
					
					ja.getJSONObject(i).put("id", pedido.getIdPedido());
					ja.getJSONObject(i).put("usuario", pedido.getUsuario());
					ja.getJSONObject(i).put("nombre", pedido.getNombre());
					ja.getJSONObject(i).put("producto", pedido.getProducto());
					ja.getJSONObject(i).put("cantidad", pedido.getCantidad());
					ja.getJSONObject(i).put("estado", pedido.getEstadoPedido().toString());
					
					encontrado = true;
				}
			}
		}
		return encontrado;
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

	@Override
	public List<PedidosTransfer> buscaListaPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

}
