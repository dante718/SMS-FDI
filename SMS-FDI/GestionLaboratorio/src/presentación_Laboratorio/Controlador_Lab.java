package presentación_Laboratorio;

import java.util.List;

import negocio_Laboratorio.FactoriaSA_Lab;
import negocio_Laboratorio.TransferProducto_Lab;

public class Controlador_Lab extends FactoriaControlador_Lab {
	
	
	public void addProducto(int id_Producto,int cantidad) {
		FactoriaSA_Lab.getInscania().addProducto(id_Producto, cantidad);
	}
	public void borrarProducto(int id_Producto) {
		TransferProducto_Lab p=null;
		p=FactoriaSA_Lab.getInscania().buscarProductoEnPedido(id_Producto);
		FactoriaSA_Lab.getInscania().borrarProducto(p);
	}
	public void guardarPedido() {
		FactoriaSA_Lab.getInscania().guardarPedido();
		FactoriaSA_Lab.getInscania().crearPedido();
	}
	public List<TransferProducto_Lab> listarPedido() {
		List<TransferProducto_Lab> lista=FactoriaSA_Lab.getInscania().ListarPedido();
		return lista;
	}
	public int Id_Pedido() {
		return FactoriaSA_Lab.getInscania().Id_Pedido();
	}
}
