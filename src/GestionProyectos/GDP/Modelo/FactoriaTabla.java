package GestionProyectos.GDP.Modelo;

public class FactoriaTabla implements FactoriaAbstracta<ModeloTablaPersona, ModeloTablaProyectos>{
    private static FactoriaTabla instancia=null;
    
    private FactoriaTabla() {};
    
    public static FactoriaTabla getInstancia() {
    	if(instancia==null) {
    		instancia= new FactoriaTabla();
    	}
    	return instancia;
    }
	
	
	@Override
	public ModeloTablaPersona CrearObjetoPersona() {
		return FactoriaDAO.getInstancia().CrearObjetoPersona().creartablaPersonas();
	}

	@Override
	public ModeloTablaProyectos CrearObjetoProyecto() {	
		return FactoriaDAO.getInstancia().CrearObjetoProyecto().creartablaProyectos();
	}

}
