package GestionDeFabrica.Modelo;

public class PedidosLaboratorio {
	
	protected String id;
	protected int cantidad;
	protected String producto;
	protected String descripcion;
	
	PedidosLaboratorio(String id, int cantidad, String producto, String descripcion){
		
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.descripcion = descripcion;
		
	}

	public void addCantidad(int cant) {
		this.cantidad = cantidad + cant;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
