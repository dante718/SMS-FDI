package GestionProyectos.GDP.Integracion;

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
		return new ModeloTablaPersona();
	}

	@Override
	public ModeloTablaProyectos CrearObjetoProyecto() {	
		return new ModeloTablaProyectos();
	}

}
