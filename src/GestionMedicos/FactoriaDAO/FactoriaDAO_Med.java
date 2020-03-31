package GestionMedicos.FactoriaDAO;


public abstract class FactoriaDAO_Med {

	private static FactoriaDAO_Med instancia=null;
	
	static public FactoriaDAO_Med getInstancia(){
		
		if (instancia == null) instancia= new FactoriaDAO_Med_imp();
	
		return instancia;
	}
	
	public abstract DAODatosPlantilla crearDAOPlantilla();
	
	public abstract DAODatosClinicos CrearTablaDatosClinicos();
	

	
}
