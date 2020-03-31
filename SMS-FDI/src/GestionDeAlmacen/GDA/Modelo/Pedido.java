package GDA.Modelo;

public class Pedido {
	
	private int _id;
	private Producto[] _productos;
	
	public Pedido(int id, Producto[] productos){
		_id = id;
		_productos = productos;
	}

	public int get_id() {
		return _id;
	}

	public Producto[] get_productos() {
		return _productos;
	}
}
