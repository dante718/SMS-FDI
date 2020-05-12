package GestionProyectos.GDP.Integracion;

import java.util.List;

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
	public DAOPersona CrearObjetoPersona(List<Object> datos) {
		DAOPersona ret= DAOPersonaImp.getInstancia();
		return ret;
	}

	@Override
	public DAOProyecto CrearObjetoProyecto(List<Object> datos) {
		DAOProyecto ret= DAOProyectoImp.getInstancia();	
		return ret;
	}

}
