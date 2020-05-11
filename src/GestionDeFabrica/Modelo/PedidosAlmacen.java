package GestionDeFabrica.Modelo;

public class PedidosAlmacen extends Event{

	protected String id;
	protected int cantidad;
	protected String producto;
	protected String descripcion;
	
	PedidosAlmacen(String id, int cantidad, String producto, String descripcion){
		
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.descripcion = descripcion;
	}

	public void addCantidad(int cant) {
		this.cantidad = cantidad + cant;
	}
	
	@Override
	void execute(MapaFabrica mapa) {
		// TODO Auto-generated method stub
		
		PedidosAlmacen pa = new PedidosAlmacen(this.id, this.cantidad, this.producto, this.descripcion);
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

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
