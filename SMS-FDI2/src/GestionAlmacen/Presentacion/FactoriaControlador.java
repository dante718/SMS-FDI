package GestionAlmacen.Presentacion;

public class FactoriaControlador {
	
	private static Controlador instancia = null;
	static public Controlador getInstancia() {
		if(instancia == null) instancia = new Controlador();
		return instancia;
	}
}