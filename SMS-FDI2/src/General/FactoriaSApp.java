package General;

import GestionLaboratorio.negocio_Laboratorio.SAPedido_Lab;
import GestionMedicos.CapaDeNegocio.FactoriaServAppMed_Imp;

//Autor Luis Gabriel Roman Santillan, Gestion de Medicos

public abstract class FactoriaSApp {	
private static FactoriaSApp instanciaMed=null;
	
static public FactoriaSApp getInstancia_Med() {
	
		if((instanciaMed==null)) {
			instanciaMed=new FactoriaServAppMed_Imp();
		}
		return instanciaMed;
		
	}
	private static FactoriaSApp instanciaLab=null;
	
	static public FactoriaSApp getInscania() {    
		
		if (instanciaLab == null) instanciaLab= new SAPedido_Lab(); //Asegurar de que solo haya una instancia de SAPedido
		
		return instanciaLab;
	}
	
}



