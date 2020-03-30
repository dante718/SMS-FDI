package GDA.Modelo;

public class Producto {
	
	private int _id; // IDENTIFICADOR
	private String _nombre; // NOMBRE
	private int _cantidad; // CANTIDAD
	private double _precio; // PRECIO
	
	public Producto(int id, String nombre, int cantidad, double precio){
		_id = id;
		_nombre = nombre;
		_cantidad = cantidad;
		_precio = precio;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public int get_cantidad() {
		return _cantidad;
	}

	public void set_cantidad(int _cantidad) {
		this._cantidad = _cantidad;
	}

	public double get_precio() {
		return _precio;
	}

	public void set_precio(double _precio) {
		this._precio = _precio;
	}
	
	
}
