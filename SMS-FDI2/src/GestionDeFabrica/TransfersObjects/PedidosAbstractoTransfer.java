package GestionDeFabrica.TransfersObjects;

import org.json.JSONObject;

import GestionDeFabrica.PresentacionModelo.EstadoPedido;

public abstract class PedidosAbstractoTransfer implements PedidosTransfer {

	protected String type;
	protected String id;
	protected String usuario;
	protected String nombre;
	protected String compuesto;
	protected String producto;
	protected int cantidad;
	protected EstadoPedido estado2;
	
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
	
	public String getCompuesto() {
		
		return this.compuesto;
	}
	
	public void setCompuesto(String compuesto) {
		
		this.compuesto = compuesto;
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
	
	/*public String getEstadoPedido() {
		
		if (this.estado2.equals(EstadoPedido.ACEPTADO)) {
			return "aceptado";
		}
		else if(this.estado2.equals(EstadoPedido.RECHAZADO)) {
			return "rechazado";
		}
		else if (this.estado2.equals(EstadoPedido.EN_PROCESO)) {
			return "en_proceso";
		}
		return "null";
	}*/
	public EstadoPedido getEstadoPedido() {
	
		return this.estado2;
	}
	
	public void setEstadoPedido(String estado1) {
		
		//if (estado != null) {
		//	EstadoPedido temp = EstadoPedido.valueOf(estado.toUpperCase());
		//	this.estado = temp;
		//}\
		if (estado1.equals("aceptado")) {
			this.estado2 = EstadoPedido.ACEPTADO;
		}
		else if(estado1.equals("rechazado")) {
			this.estado2 = EstadoPedido.RECHAZADO;
		}
		else if(estado1.equals("en_proceso")) {
			this.estado2 = EstadoPedido.EN_PROCESO;
		}
	}
}
