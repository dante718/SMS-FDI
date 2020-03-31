package GestionLaboratorio.negocio_Laboratorio;
import java.util.List;

import GestionLaboratorio.negocio_Laboratorio.TransferProducto_Lab;

import java.util.ArrayList;

public class TransferPedido_Lab {
	static int numeroPedido=100;
	
	private int _idPedido;
	private String _idSolicitante;
	private String _NombreSolicitante;
	private List<TransferProducto_Lab>_productos;
	
	
	public TransferPedido_Lab() {
		_productos = new ArrayList<>();
		_idPedido=numeroPedido;
		numeroPedido+=2;
	}
	
	public int get_idPedido() {
		return _idPedido;
	}
	
	
	public void set_idPedido(int _idPedido) {
		this._idPedido = _idPedido;
	}
	
	
	public String get_idSolicitante() {
		return _idSolicitante;
	}
	
	
	public void set_idSolicitante(String _idSolicitante) {
		this._idSolicitante = _idSolicitante;
	}
	
	
	public String get_NombreSolicitante() {
		return _NombreSolicitante;
	}
	
	
	public void set_NombreSolicitante(String _NombreSolicitante) {
		this._NombreSolicitante = _NombreSolicitante;
	}


	public List<TransferProducto_Lab> get_productos() {
		return _productos;
	}


	public void set_productos(List<TransferProducto_Lab> _productos) {
		this._productos = _productos;
	}

	
}
