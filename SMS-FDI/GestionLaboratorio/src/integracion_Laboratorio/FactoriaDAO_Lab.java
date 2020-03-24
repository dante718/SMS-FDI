package integracion_Laboratorio;

public abstract class FactoriaDAO_Lab {


	private static FactoriaDAO_Lab instancia=null;
	
	static public FactoriaDAO_Lab getInstancia()
	{
		if (instancia == null) instancia= new FactoriaDAO_Lab_imp();
	
		return instancia;
	}
	public abstract DAOProducto_Lab crearDAOProducto();
	
	public abstract DAOPedido_Lab crearDAOPedido();
	
}
