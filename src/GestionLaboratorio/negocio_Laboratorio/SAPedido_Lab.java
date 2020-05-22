package GestionLaboratorio.negocio_Laboratorio;


import java.util.ArrayList;
import java.util.List;

import General.FactoriaDAO;
import General.FactoriaSApp;


public class SAPedido_Lab extends FactoriaSApp  {
	
	private TransferPedido_Lab pedido;
	
	public SAPedido_Lab() {
		crearPedido();
	}
	
	public void crearPedido() {
		   pedido=FactoriaDAO.getInstancia_Lab().crearDAOPedido().crearPedido();
		   ModificaPedido(pedido, null, null, null);
	}

	public void addProducto(int id_Producto,int cantidad) {
		TransferProducto_Lab ProductoBuscado=null;
		ProductoBuscado=FactoriaDAO.getInstancia_Lab().crearDAOProducto().ConsultaStock(id_Producto, cantidad);
		if(ProductoBuscado!=null) {
			List<TransferProducto_Lab>lista =pedido.get_productos();
			lista.add(ProductoBuscado);
			ModificaPedido(pedido, null, null, lista);
			
		}
		else { 
			throw new IllegalArgumentException("El producto no esta en BBDD de Almacen");
		}
		
	}
	public TransferProducto_Lab buscarProductoEnPedido(int id_codigo) {
		TransferProducto_Lab buscado=null;
		List<TransferProducto_Lab> list = pedido.get_productos();
		for(int i = 0; i < list.size(); i++) {
			if(id_codigo == list.get(i).get_idProducto()) {
				buscado=list.get(i);
			}
		}
		return buscado;
	}
	
	public List<TransferProducto_Lab> ListarPedido(){
		
		List<TransferProducto_Lab> lista =pedido.get_productos();
		
		return lista;
	}
	
	public void borrarProducto(TransferProducto_Lab producto) {
		List<TransferProducto_Lab>lista =pedido.get_productos();
		if(lista.contains(producto)) {
			lista.remove(producto);
			ModificaPedido(pedido, null, null, lista);
		}
		else {
			throw new IllegalArgumentException("El producto no esta en el pedido");
		}
	}
	
	public void ModificaPedido(TransferPedido_Lab ped,String idSolicitante, String NombreSolicitante,List<TransferProducto_Lab> productos) {
		if(ped!=null) {
			if(idSolicitante!=null) ped.set_idSolicitante(idSolicitante);
			if(NombreSolicitante!=null) ped.set_NombreSolicitante(NombreSolicitante);
			if(productos!=null) ped.set_productos(productos);
		}
	}
	
	
	
	public TransferPedido_Lab BuscarPedido(String id_ped) {
	
		pedido= FactoriaDAO.getInstancia_Lab().crearDAOPedido().BuscarPedidoEnsisPedidos(id_ped);
		
		
		
		return pedido;
	}
	
	
	public void EliminarPedido(String id_ped) {
		FactoriaDAO.getInstancia_Lab().crearDAOPedido().EliminarPedido(id_ped);
	}

	
	
	public void guardarPedido() {
		FactoriaDAO.getInstancia_Lab().crearDAOPedido().guardarPedidoEnSisPedidos(pedido);;
	}
	public int Id_Pedido() {
		return pedido.get_idPedido();
	}
	public String Id_Solicitante() {
		return pedido.get_idSolicitante();
	}
	public String Nombre_Solicitante() {
		return pedido.get_NombreSolicitante();
	}
	public void DemoMod() {
		pedido.set_idSolicitante("AXXSA");
		pedido.set_NombreSolicitante("ALEX");
		TransferProducto_Lab producto1 = new TransferProducto_Lab();
		producto1.set_idProducto(1331);
		producto1.set_cantidad(2);
		producto1.set_nombre("jeringa");
		TransferProducto_Lab producto2 = new TransferProducto_Lab();
		producto2.set_idProducto(1234);
		producto2.set_cantidad(2);
		producto2.set_nombre("Alcohol");
		TransferProducto_Lab producto3 = new TransferProducto_Lab();
		producto3.set_idProducto(1654);
		producto3.set_cantidad(4);
		producto3.set_nombre("Acido");
		
	    List<TransferProducto_Lab> pro = new ArrayList<TransferProducto_Lab>();
	    pro.add(producto1);
	    pro.add(producto2);
	    pro.add(producto3);
	    pedido.set_productos(pro);
	}
}
