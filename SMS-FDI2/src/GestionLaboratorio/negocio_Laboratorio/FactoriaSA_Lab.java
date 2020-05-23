package GestionLaboratorio.negocio_Laboratorio;

public abstract class FactoriaSA_Lab {
	private static SAPedido_Lab instancia=null;
	
	static public SAPedido_Lab getInscania() {    
		
		if (instancia == null) instancia= new SAPedido_Lab(); //Asegurar de que solo haya una instancia de SAPedido
		
		return instancia;
	}
	
	
}
