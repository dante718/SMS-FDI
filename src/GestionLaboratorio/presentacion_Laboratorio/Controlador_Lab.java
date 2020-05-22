package GestionLaboratorio.presentacion_Laboratorio;

import java.util.List;

import GestionLaboratorio.negocio_Laboratorio.FactoriaSA_Lab;
import GestionLaboratorio.negocio_Laboratorio.TransferProducto_Lab;

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
	public TransferProducto_Lab BuscarPedido(String id_ped){
		TransferProducto_Lab p=null;
		FactoriaSA_Lab.getInscania().BuscarPedido(id_ped);
		
		return p;
	}
	public void Demo() {
		FactoriaSA_Lab.getInscania().DemoMod();
		
	}
	public String Id_Solicitante() {
		return FactoriaSA_Lab.getInscania().Id_Solicitante();
	}
	public String Id_NombreSolicitante() {
		return FactoriaSA_Lab.getInscania().Nombre_Solicitante();
	}
	public void EliminarPedido(String id_ped) {
		
		FactoriaSA_Lab.getInscania().EliminarPedido(id_ped);
	}
	
	
	
	
	}
