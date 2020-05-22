package GestionDeInformatica.GDI.Modelo;

public class GDI_FactoriaSA_Inf_imp{
	private static GDI_SA instanciaInf=null;
static public GDI_SA getInstancia_Inf() {    
		
		if (instanciaInf == null) instanciaInf= new GDI_SA(); //Asegurar de que solo haya una instancia de SAPedido
		
		return instanciaInf;
	}
	
}
