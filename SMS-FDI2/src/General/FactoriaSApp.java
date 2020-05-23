package General;

import GestionAlmacen.Negocio.SAAlmacen;
import GestionDeInformatica.GDI.Modelo.GDI_SA;
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
	
	private static FactoriaSApp instanciaAlmacen = null;
	
	static public FactoriaSApp getInstancia() {
		if(instanciaAlmacen == null) instanciaAlmacen = new SAAlmacen();
		return instanciaAlmacen;
	}
	
private static FactoriaSApp instanciaInf=null;
	
	static public FactoriaSApp getInstancia_Inf() {    
		
		if (instanciaInf == null) instanciaInf= new GDI_SA(); //Asegurar de que solo haya una instancia de GDI_SA
		
		return instanciaInf;
	}
	
	
}



