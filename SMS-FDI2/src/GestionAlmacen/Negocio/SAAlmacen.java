package GestionAlmacen.Negocio;

import java.util.ArrayList;

import General.FactoriaAbstractaDAO;
import General.FactoriaSApp;

public class SAAlmacen extends FactoriaSApp{
	
	//Productos
	public void leerProductos() {
		FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProductoAlmacen().leerBD();
	}
	
	public ArrayList<TProducto> getProductos() {
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProductoAlmacen().getProductos();
	}
	
	public void escribirBD(ArrayList<TProducto> productos) {
		FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProductoAlmacen().writeBD(productos);
	}
	
	public ArrayList<TProducto> addProducto(TProducto producto){
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProductoAlmacen().addProducto(producto);
	}
	
	public ArrayList<TProducto> eliminarProducto(int id) {
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProductoAlmacen().eliminarProducto(id);
	}
	
	//Pedidos
	public void leerPedidos() {
		FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOPedidoAlmacen().leerBD();
	}
	
	public ArrayList<TPedido> getPedidos(){
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOPedidoAlmacen().getPedidos();
	}
	
	//Proveedores
	public void leerProveedores() {
		FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProveedor().leerBD();
	}
	
	public ArrayList<TProveedor> getProveedores(){
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProveedor().getProveedores();
	}
	
	public void escribirBDProveedores(ArrayList<TProveedor> proveedores) {
		FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProveedor().writeBD(proveedores);
	}
	
	public ArrayList<TProveedor> addProveedor(TProveedor proveedor){
		return FactoriaAbstractaDAO.getInstancia_Almacen().crearDAOProveedor().addProveedor(proveedor);
	}
}
