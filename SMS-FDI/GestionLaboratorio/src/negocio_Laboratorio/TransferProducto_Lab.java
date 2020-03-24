package negocio_Laboratorio;

public class TransferProducto_Lab {
	
	private int _idProducto;
	private String _descripcion;
	private String _nombre;
	private int _cantidad;
	
	public TransferProducto_Lab() {
		_cantidad=0;
	}
	
	public int get_idProducto() {
		return _idProducto;
	}
	
	public void set_idProducto(int _idProducto) {
		this._idProducto = _idProducto;
	}
	
	public String get_descripcion() {
		return _descripcion;
	}
	
	public void set_descripcion(String _descripcion) {
		this._descripcion = _descripcion;
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
	
}
