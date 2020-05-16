package GestionDeFabrica.TransfersObjects;

import org.json.JSONObject;

import GestionDeFabrica.Modelo.EstadoPedido;

public abstract class PedidosTransfer {

	protected String type;
	protected String id;
	protected String usuario;
	protected String nombre;
	protected String producto;
	protected int cantidad;
	protected EstadoPedido estado;
	
	public String getType() {
		
		return this.type;
	}
	
	public void setType(String type) {
		
		this.type = type;
	}
	
	public String getIdPedido() {
		
		return this.id;
	}
	
	public void setIdPedido(String id) {
		
		this.id = id;
	}
	
	public String getUsuario() {
		
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		
		this.usuario = usuario;
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public String getProducto() {
		
		return this.producto;
	}
	
	public void setProducto(String producto) {
		
		this.producto = producto;
	}
	
	public int getCantidad() {
		
		return this.cantidad;
	}
	
	public void setCantidad(int cantidad) {
		
		this.cantidad = cantidad;
	}
	
	public EstadoPedido getEstadoPedido() {
		
		return this.estado;
	}
	
	public void setEstadoPedido(String estado) {
		
		EstadoPedido temp = EstadoPedido.valueOf(estado.toUpperCase());
		this.estado = temp;
	}
}
