package GestionAlmacen.Negocio;

public abstract class FactoriaSA {
	
	private static SAAlmacen instancia = null;
	
	static public SAAlmacen getInstancia() {
		if(instancia == null) instancia = new SAAlmacen();
		return instancia;
	}
}