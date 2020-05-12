package GestionProyectos.GDP.Negocio;

import java.util.List;

import GestionProyectos.GDP.Integracion.FactoriaAbstracta;

public class FabricaTransfer implements FactoriaAbstracta<TPersona, TProyecto>{
      private static FabricaTransfer instancia=null;
      
      public static FabricaTransfer getInstancia() {
    	  if(instancia==null) {
    		  instancia= new FabricaTransfer();
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
}
