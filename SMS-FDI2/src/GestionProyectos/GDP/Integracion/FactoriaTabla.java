package GestionProyectos.GDP.Integracion;

import java.util.List;

import GestionProyectos.GDP.FactoriaAbstracta.FactoriaAbstracta;
import GestionProyectos.GDP.Presentacion.IVista;

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
	public ModeloTablaPersona CrearObjetoPersona(List<Object> datos) {
		return new ModeloTablaPersona();
	}

	@Override
	public ModeloTablaProyectos CrearObjetoProyecto(List<Object> datos) {	
		return new ModeloTablaProyectos();
	}

	@Override
	public IVista CrearObjetoVista(String tipo) {
		return null;
	}

}
