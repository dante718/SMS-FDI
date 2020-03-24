package integracion_Laboratorio;

public class FactoriaDAO_Lab_imp extends FactoriaDAO_Lab{
	
	public DAOProducto_Lab crearDAOProducto() {
		return new DAOProducto_Lab();
	}
	public DAOPedido_Lab crearDAOPedido() {
		return new DAOPedido_Lab();
	}
	
}
