package GestionProyectos.GDP.Negocio;

import java.util.List;

import GestionProyectos.GDP.FactoriaAbstracta.FactoriaAbstracta;
import GestionProyectos.GDP.Presentacion.IVista;

public class FactoriaTransfer implements FactoriaAbstracta<TPersona, TProyecto>{
      private static FactoriaTransfer instancia=null;
      
      public static FactoriaTransfer getInstancia() {
    	  if(instancia==null) {
    		  instancia= new FactoriaTransfer();
    	  }
    	  return instancia;
      }

	@Override
	public TPersona CrearObjetoPersona(List<Object> datos) {	
		return new TPersona().crearObjeto(datos);
	}

	@Override
	public TProyecto CrearObjetoProyecto(List<Object> datos) {		
		return new TProyecto().crearObjeto(datos);
	}

	@Override
	public IVista CrearObjetoVista(String tipo) {
		return null;
	}
}
