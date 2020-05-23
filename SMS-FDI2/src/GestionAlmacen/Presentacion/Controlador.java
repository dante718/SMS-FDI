package GestionAlmacen.Presentacion;

import java.util.ArrayList;

import GestionAlmacen.Negocio.FactoriaSA;
import GestionAlmacen.Negocio.TPedido;
import GestionAlmacen.Negocio.TProducto;
import GestionAlmacen.Negocio.TProveedor;


public class Controlador extends FactoriaControlador{
	
	//Productos
	public void leerProductos() {
		FactoriaSA.getInstancia().leerProductos();
	}
	
	public ArrayList<GestionAlmacen.Negocio.TProducto> getProductos() {
		return FactoriaSA.getInstancia().getProductos();
	}
	
	public void escribirBD(ArrayList<TProducto> productos) {
		FactoriaSA.getInstancia().escribirBD(productos);
	}
	
	public ArrayList<TProducto> addProducto(TProducto producto){
		return FactoriaSA.getInstancia().addProducto(producto);
	}
	
	public ArrayList<TProducto> eliminarProducto(int id) {
		return FactoriaSA.getInstancia().eliminarProducto(id);
	}
	
	//Pedidos
	public void leerPedidos() {
		FactoriaSA.getInstancia().leerPedidos();
	}
	
	public ArrayList<TPedido> getPedidos(){
		return FactoriaSA.getInstancia().getPedidos();
	}
	
	//Proveedores
	public void leerProveedores() {
		FactoriaSA.getInstancia().leerProveedores();
	}
	
	public ArrayList<TProveedor> getProveedores(){
		return FactoriaSA.getInstancia().getProveedores();
	}
	
	public void escribirBDProveedores(ArrayList<TProveedor> proveedores) {
		FactoriaSA.getInstancia().escribirBDProveedores(proveedores);
	}
	
	public ArrayList<TProveedor> addProveedor(TProveedor proveedor){
		return FactoriaSA.getInstancia().addProveedor(proveedor);
	}
}
