package GestionProyectos.GDP.Integracion;

public class FactoriaDAO implements FactoriaAbstracta<DAOPersona, DAOProyecto>{
	private static FactoriaDAO instancia=null;
	private FactoriaDAO() {};
	public static FactoriaDAO getInstancia() {
		if(instancia==null) {
			instancia= new FactoriaDAO();
		}
		return instancia;
	}
	
	@Override
	public DAOPersona CrearObjetoPersona() {
		DAOPersona ret= DAOPersonaImp.getInstancia();
		return ret;
	}

	@Override
	public DAOProyecto CrearObjetoProyecto() {
		DAOProyecto ret= DAOProyectoImp.getInstancia();	
		return ret;
	}

}
