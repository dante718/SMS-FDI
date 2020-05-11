package GestionProyectos.GDP.Negocio;

import java.util.List;

public class FabricaTransfer {
      private static FabricaTransfer instancia=null;
      
      public static FabricaTransfer getInstancia() {
    	  if(instancia==null) {
    		  instancia= new FabricaTransfer();
    	  }
    	  return instancia;
      }
      
      public ITransfer<?> getTransfer(String tipoTransfer, List<Object> Datos) {
    	  if(tipoTransfer.toLowerCase().equals("persona")) {
    		  return new TPersona().crearObjeto(Datos);
    	  }
    	  else if(tipoTransfer.toLowerCase().equals("proyecto")) {
    		  return new TProyecto().crearObjeto(Datos);
    	  }
    	  else {
    		  return null;
    	  }
      }
}
