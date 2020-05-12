package General;

import GestionLaboratorio.negocio_Laboratorio.SAPedido_Lab;
import GestionMedicos.FactoriaServAplicacion.FactoriaServAppMed_Imp;

//Autor Luis Gabriel Roman Santilla, Gestion de Medicos
public abstract class FactoriaSApp {
	
private static FactoriaSApp instanciaMed=null;

	static public FactoriaSApp getInstancia_Med(String estudio, String pastilla, String etapa,String ruta) {
		if(instanciaMed==null) {
			instanciaMed=new FactoriaServAppMed_Imp(estudio,pastilla,etapa, ruta);
		}
		return instanciaMed;
		
	}
	
	private static FactoriaSApp instanciaLab=null;
	
	static public FactoriaSApp getInscania() {    
		
		if (instanciaLab == null) instanciaLab= new SAPedido_Lab(); //Asegurar de que solo haya una instancia de SAPedido
		
		return instanciaLab;
	}
	
	
}
