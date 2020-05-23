package GestionAlmacen.Negocio;

public class TProducto {
	
	private int _id, _cantidad;
	private String _descripcion, _nombre;
	
	//ID
	public int getIdProducto() { return _id; }
	public void setIdProducto(int id) { this._id = id; }
	
	//Nombre
	public String getNombreProducto() { return _nombre; }
	public void setNombreProducto(String nombre) { this._nombre = nombre; }
	
	//Descripcion
	public String getDescripcionProducto() { return _descripcion; }
	public void setDescripcionProducto(String descripcion) { this._descripcion = descripcion; }
	
	//Cantidad
	public int getCantidadProducto() { return _cantidad; }
	public void setCantidadProducto(int cantidad) { this._cantidad = cantidad; }
	
	
}