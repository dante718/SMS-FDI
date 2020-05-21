package GestionDeFabrica.Modelo;

public abstract class Pedidos {

	String type;
	String id;
	String usuario;
	String nombre;
	String producto;
	int cantidad;
	EstadoPedido estado;
	
	Pedidos(String type, String id, String usuario, String nombre,
			String producto, int cantidad, EstadoPedido estado){
		
		this.type = type;
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.producto = producto;
		this.cantidad = cantidad;
		this.estado = estado;
	}
	
	public abstract void ingresaPedido(MapaFabrica mapa);
	public abstract void eliminaPedido(MapaFabrica mapa);
	public abstract void modificaPedido(MapaFabrica mapa);

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	
	
}
