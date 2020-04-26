package GestionDeEnvios.GDE.Modelo;



public abstract class FactoriaEnvios {

	
private static FactoriaEnvios instancia=null;
	
	static public FactoriaEnvios getInstancia()
	{
		if (instancia == null) instancia= new FactoriaEnviosDao();
	
		return instancia;
	}	
	public abstract DaoEnvios crearDAOEnvios();
}
