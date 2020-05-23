package GestionAlmacen.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TPedido {
	
	private String _id, _idSolicitante, _nombreSolicitante;
	private ArrayList<String> _productos;
	
	//ID
	public String getIdPedido() { return _id; }
	public void setIdPedido(String id) { this._id = id; }
	
	//ID del Solicitante
	public String getIdSolicitante() { return _idSolicitante; }
	public void setIdSolicitante(String idSolicitante) { this._idSolicitante = idSolicitante; }
	
	//Nombre del solicitante
	public String getNombreSolicitante() { return _nombreSolicitante; }
	public void setNombreSolicitante(String nombreSolicitante) { this._nombreSolicitante = nombreSolicitante; }
	
	//Lista de productos
	public ArrayList<String> getProductos() { return _productos; }
	public void setProductos(ArrayList<String> productos) { this._productos = productos; }
}